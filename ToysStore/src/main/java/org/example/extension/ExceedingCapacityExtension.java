package org.example.extension;

public class ExceedingCapacityExtension extends ToyStoreExtension{
    private int count;
    private int capacity;

    public ExceedingCapacityExtension(String message, int count, int capacity) {
        super(message);
        this.count = count;
        this.capacity = capacity;
    }

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return capacity;
    }
}
