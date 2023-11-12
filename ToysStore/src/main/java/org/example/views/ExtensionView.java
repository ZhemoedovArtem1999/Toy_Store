package org.example.views;

import org.example.extension.ExceedingCapacityExtension;
import org.example.extension.InitException;
import org.example.extension.ToyStoreExtension;
import org.example.extension.ToysEmptyExtension;

import java.util.logging.Logger;

public class ExtensionView implements ExtensionOutputInterface {

    @Override
    public void viewExtensionToyStore(ToyStoreExtension extension) {
        if (extension instanceof  ExceedingCapacityExtension)
        {
            ExceedingCapacityExtension exceedingCapacityExtension = (ExceedingCapacityExtension) extension;
            System.out.println(exceedingCapacityExtension.getMessage() + " Количество игрушек в магазине - " + exceedingCapacityExtension.getCount() + " Вместимость магазина - " + exceedingCapacityExtension.getCapacity());
        }
        if (extension instanceof ToysEmptyExtension)
        {
            System.out.println(extension.getMessage());
        }
        if (extension instanceof InitException)
        {
            System.out.println(extension.getMessage());
        }
    }
}
