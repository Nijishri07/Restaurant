package com.rest.payment;

public class cardPayment implements paymentmethod {
    @Override 
    public void pay(double amount){
        System.out.printf("Card payment of Rs. %.2f successful.%n", amount);
    }
    @Override 
    public String getMethodName(){
        return "Card";
    }
}

