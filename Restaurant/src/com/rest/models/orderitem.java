
package com.rest.models;

public class orderitem {

    private int id;
    private menuitem item;
    private int quantity;
    private double subtotal;

    public orderitem(int id, menuitem item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.subtotal = item.getprice() * quantity;
    }

    public int getid() {
        return id;
    }

    public menuitem getitem() {
        return item;
    }

    public int getquantity() {
        return quantity;
    }

    public double getsubtotal() {
        return subtotal;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
        this.subtotal = item.getprice() * quantity;
    }

    @Override
    public String toString() {
        return item.getname()
                + " | Quantity: " + quantity
                + " | Price: Rs. " + item.getprice()
                + " | Subtotal: Rs. " + subtotal;
    }
}
