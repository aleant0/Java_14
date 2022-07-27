package ru.netology.domain;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String manufacturer, String name, int price) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }
}
