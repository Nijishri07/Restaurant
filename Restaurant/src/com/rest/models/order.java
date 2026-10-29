
package com.rest.models;

import java.util.ArrayList;
import java.util.List;

public class order {

    private int id;
    private int tableId;
    private List<orderitem> items;
    private double totalAmount;

    public order(int id, int tableId) {
        this.id = id;
        this.tableId = tableId;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public int getid() {
        return id;
    }

    public int gettableId() {
        return tableId;
    }

    public List<orderitem> getitems() {
        return items;
    }

    public double gettotalAmount() {
        return totalAmount;
    }

    public void additem(orderitem item) {
        items.add(item);
        totalAmount += item.getsubtotal();
    }

    @Override
    public String toString() {
        return "Order ID: " + id
                + "\nTable ID: " + tableId
                + "\nItems: " + items
                + "\nTotal Amount: Rs. " + totalAmount;
    }
}
