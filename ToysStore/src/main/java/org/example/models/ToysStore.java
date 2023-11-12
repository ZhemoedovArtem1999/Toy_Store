package org.example.models;

import org.example.extension.ExceedingCapacityExtension;

import java.util.ArrayList;
import java.util.List;

public class ToysStore {
    private List<Toy> toys;
    private int count = 0;

    private int capacity = 100;

    public ToysStore() {
        toys = new ArrayList<>();
    }

    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void addToy(Toy toy) throws ExceedingCapacityExtension{

        if (count<capacity) {
            toys.add(toy);
            count += toy.getCount();
        }
        else {
            throw new ExceedingCapacityExtension("Превышение вместимости магазина", count, capacity);
        }
    }


}
