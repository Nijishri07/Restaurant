package com.rest.models;

import java.util.ArrayList;
import java.util.List;

public class bill {

    private int billId;
    private int orderId;
    private List<orderitem> items;
    private double totalAmount;

    public bill(int billId, order orderDetails) {
        this.billId = billId;
        this.orderId = orderDetails.getid();
        this.items = new ArrayList<>(orderDetails.getitems());
        this.totalAmount = orderDetails.gettotalAmount();
    }

    public int getbillId() {
        return billId;
    }

    public int getorderId() {
        return orderId;
    }

    public List<orderitem> getitems() {
        return new ArrayList<>(items);
    }

    public double gettotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("\n========== RESTAURANT BILL ==========\n");
        result.append("Bill ID: ").append(billId).append("\n");
        result.append("Order ID: ").append(orderId).append("\n");
        result.append("-------------------------------------\n");

        for (orderitem item : items) {
            result.append(item).append("\n");
        }

        result.append("-------------------------------------\n");
        result.append("Total Amount: Rs. ").append(totalAmount).append("\n");
        result.append("=====================================");

        return result.toString();
    }
}