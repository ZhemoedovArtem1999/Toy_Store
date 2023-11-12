package org.example.services;

import org.example.extension.ExceedingCapacityExtension;
import org.example.extension.InitException;
import org.example.extension.ToysEmptyExtension;
import org.example.models.Toy;
import org.example.models.ToysStore;

import java.util.List;
import java.util.Random;

public class ToyStoreService implements IToyStoreService, IToyStoreRebalanceFrequence {
    private ToysStore toysStore;

    public ToyStoreService() {
        this.toysStore = new ToysStore();
    }

    @Override
    public List getAllToys() {
        return toysStore.getToys();
    }

    @Override
    public void init(){
        if (toysStore.getToys().isEmpty()) {
            this.addToy("Плюшевый медведь", 4);
            this.addToy("Робот", 3);
            this.addToy("Акула", 2);
            this.addToy("Кукла", 1);
        }
        else {
            throw new InitException("Проинициализировать невозможно. В магазине уже есть игрушки");
        }

    }

    @Override
    public void addToy(String title, int count) throws ExceedingCapacityExtension {
        Toy toy = new Toy(calculateId(), title, count);
        for (var toyStore : toysStore.getToys()) {
            if (toyStore.getTitle().equals(toy.getTitle())) {
                toyStore.setCount(toyStore.getCount() + toy.getCount());
                toysStore.setCount(toysStore.getCount() + toy.getCount());
                rebalanceFrecuence();
                return;
            }
        }
        toysStore.addToy(toy);
        rebalanceFrecuence();
    }

    @Override
    public Toy pullToy() throws ToysEmptyExtension {
        if (toysStore.getToys().isEmpty()){
            throw new ToysEmptyExtension("В магазине игрушек нет");
        }
        else {
            Random rnd = new Random();
            var ids = this.createArrayIds();
            int id = ids[rnd.nextInt(0, ids.length)];
            return this.getToyInId(id);

        }
    }

    private int[] createArrayIds(){
        int[] arrayIds = new int[toysStore.getCount()];
        var toys = toysStore.getToys();
        int index = 0;
        for (var toy : toys){
            for(int i = index; i < index + toy.getCount();i++)
            {
                arrayIds[i] = toy.getId();
            }
            index = index + toy.getCount();
        }
        return arrayIds;
    }

    private Toy getToyInId(int id){
        for (var toy: toysStore.getToys()){
            if (toy.getId() == id)
            {
                return toy;
            }
        }
        return null;
    }

    public void deleteToy(Toy toy)
    {
        toy.setCount(toy.getCount()-1);
        if (toy.getCount() == 0)
        {
            var toys = toysStore.getToys();
            toys.remove(toy);
        }
        toysStore.setCount(toysStore.getCount() - 1);
        rebalanceFrecuence();
    }

    private int calculateId()
    {
        int id = 0;
        List<Toy> toys = toysStore.getToys();
        for(var toy : toys){
            if(toy.getId() > id)
                id = toy.getId();
        }
        return ++id;
    }

    @Override
    public void rebalanceFrecuence() {
        List<Toy> toys = toysStore.getToys();
        int allCount = toysStore.getCount();
        for (var toy: toys){
            toy.setFrequency(toy.getCount()*1.0/allCount);
        }
    }
}
