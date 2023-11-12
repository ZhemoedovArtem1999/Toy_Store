package org.example.views;

import org.example.models.Toy;

import java.util.List;

public interface OutputIToyStoreInterface {
    void getMenu();
    void statusOutput(String status);
    void showToys(List<Toy> toys);
    void showToy(Toy toy);
    void viewTitle();
    void viewCount();
}
