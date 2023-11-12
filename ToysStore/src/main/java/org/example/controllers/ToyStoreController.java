package org.example.controllers;

import org.example.extension.ExceedingCapacityExtension;
import org.example.extension.InitException;
import org.example.extension.ToysEmptyExtension;
import org.example.models.Toy;
import org.example.models.ToysStore;
import org.example.services.FileService;
import org.example.services.ToyStoreService;
import org.example.views.*;

import java.util.List;

public class ToyStoreController {
    ToyStoreService toyStoreService;

    ExtensionOutputInterface extensionView;
    OutputIToyStoreInterface toyStoreView;

    InputInterface input;

    FileService fileService;

    public ToyStoreController(OutputIToyStoreInterface output, InputInterface input, ExtensionOutputInterface extension, String filePath) {
        this.toyStoreService = new ToyStoreService();

        this.extensionView = extension;
        this.toyStoreView = output;
        this.input = input;

        this.fileService = new FileService(filePath);
    }

    public void initToys(){
        toyStoreService.init();
    }

    public void getMenuView()
    {
        toyStoreView.getMenu();
    }

    public int inputMenuClick(){
        return input.inputMenu();
    }

    public void initializeStore(){
        try{
            toyStoreService.init();
            toyStoreView.statusOutput("Магазин прошел инициализацию добавлено 10 игрушек");
        }
        catch (ExceedingCapacityExtension | InitException e)
        {
            extensionView.viewExtensionToyStore(e);
        }


    }
    public void addToy()
    {
        Toy toy = new Toy();
        toyStoreView.viewTitle();
        toy.setTitle(input.inputString());
        toyStoreView.viewCount();
        toy.setCount(input.inputInt());
        this.addToy(toy.getTitle(),toy.getCount());
    }

    public void addToy(String title, int count){
        try {
            toyStoreService.addToy(title, count);
        }
        catch (ExceedingCapacityExtension e)
        {
            extensionView.viewExtensionToyStore(e);
        }
    }

    public void showToys()
    {
        List<Toy> toys =  toyStoreService.getAllToys();
        toyStoreView.showToys(toys);
    }

    public void pullToy(){
        try {
            Toy toy = toyStoreService.pullToy();
            toyStoreView.showToy(toy);
            fileService.writeToFile(toy.toString() + "\n");
            toyStoreService.deleteToy(toy);

        }
        catch (ToysEmptyExtension e)
        {
            extensionView.viewExtensionToyStore(e);
        }

    }

    public void pullTenToys()
    {
        for(int i = 0; i < 10; i++)
        {
            this.pullToy();
        }
    }





}
