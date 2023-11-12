package org.example.services;

import org.example.models.Toy;

import java.util.List;

public interface IToyStoreService {

    void init();
    void addToy(String title, int count);

    Toy pullToy();

    List getAllToys();
}
