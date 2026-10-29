
package com.rest.models;

public class payment {

    private int id;
    private int orderId;
    private double amount;
    private String method;
    private String status;

    public payment(int id, int orderId, double amount,
                   String method,String status) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    public int getid() {
        return id;
    }

    public int getorderId() {
        return orderId;
    }

    public double getamount() {
        return amount;
    }

    public String getmethod() {
        return method;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment ID: " + id
                + ", Order ID: " + orderId
                + ", Amount: Rs. " + amount
                + ", Method: " + method
                + ", Status: " + status;
    }
}
