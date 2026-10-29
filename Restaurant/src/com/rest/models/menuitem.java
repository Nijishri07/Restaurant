
package com.rest.models;

public class menuitem {

    private int id;
    private String name;
    private double price;
    private String category;

    public menuitem(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getid() {
        return id;
    }

    public String getname() {
        return name;
    }

    public double getprice() {
        return price;
    }

    public String getcategory() {
        return category;
    }

    public void setprice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu Item ID: " + id
                + ", Name: " + name
                + ", Price: Rs. " + price
                + ", Category: " + category;
    }
}
