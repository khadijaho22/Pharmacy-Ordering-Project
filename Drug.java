package com.example.demo6;

public class Drug {
    private String name;
    private int id;
    private double price;
    private String  category;
    private int quantity;

    public Drug(String name, int id, double price, String category, int quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

}

