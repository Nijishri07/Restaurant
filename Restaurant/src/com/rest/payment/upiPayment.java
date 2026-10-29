package com.rest.payment;

public class upiPayment implements paymentmethod {
    @Override 
    public void pay(double amount){
        System.out.printf("Upi payment of Rs. %.2f successful.%n", amount);
    }
    @Override 
    public String getMethodName(){
        return "upi";
    }
}

