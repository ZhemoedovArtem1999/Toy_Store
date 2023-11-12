package org.example;

import org.example.controllers.ToyStoreController;
import org.example.extension.ExceedingCapacityExtension;
import org.example.views.ConsoleIn;
import org.example.views.ExtensionView;
import org.example.views.ToyStoreView;

public class App {
    ToyStoreController toyStoreController;



    public App() {
        this.toyStoreController = new ToyStoreController(new ToyStoreView(), new ConsoleIn(), new ExtensionView(), "output.txt");
    }
    public void run(){
        while (true) {
            toyStoreController.getMenuView();
            int task = toyStoreController.inputMenuClick();
            switch (task) {
                case 1:
                    toyStoreController.initializeStore();
                    break;
                case 2:
                    toyStoreController.pullToy();
                    break;
                case 3:
                    toyStoreController.pullTenToys();
                    break;
                case 4:
                    toyStoreController.addToy();
                    break;
                case 5:
                    toyStoreController.showToys();
                    break;
                case 6:
                    return;
                }

        }

    }
}
