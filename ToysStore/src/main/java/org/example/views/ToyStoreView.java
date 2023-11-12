package org.example.views;

import org.example.models.Toy;

import java.util.List;

public class ToyStoreView implements OutputIToyStoreInterface {

    @Override
    public void getMenu()
    {
        System.out.print("Выберите действие\n" +
                "1 - Инициализировать магазин игрушек\n" +
                "2 - Вытянуть игрушку\n" +
                "3 - Вытянуть 10 игрушек\n" +
                "4 - Добавить игрушку\n" +
                "5 - Показать доступные игрушки\n" +
                "6 - Выйти\n" +
                "Ваш выбор - ");
    }
    @Override
    public void statusOutput(String status)
    {
        System.out.println(status);
    }

    @Override
    public void showToys(List<Toy> toys) {
        if (toys.isEmpty()){
            System.out.println("Игрушек нет");
        }
        else {
            System.out.println("Доступные игрушки:");
            for (var toy : toys){
                System.out.println(toy);
            }
        }

    }
    @Override
    public void showToy(Toy toy) {
        System.out.println("Вытянули - " + toy.toString());
    }

    @Override
    public void viewTitle() {
        System.out.print("Введите название игрушки - ");
    }

    @Override
    public void viewCount() {
        System.out.print("Введите количество игрушек - ");

    }
}
