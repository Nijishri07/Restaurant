package com.rest.services;

import com.rest.models.payment;
import com.rest.repository.paymentrepository;
import com.rest.payment.paymentmethod;

import java.util.List;

public class paymentservice {

    private final paymentrepository repository;
    private int nextPaymentId = 1;

    public paymentservice() {
        repository = new paymentrepository();
    }

    public payment processPayment(int orderId, double amount,
                                  paymentmethod selectedMethod) {

        if (orderId <= 0) {
            throw new IllegalArgumentException("Invalid Order ID!");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid payment amount!");
        }

        if (selectedMethod == null) {
            throw new IllegalArgumentException("Invalid payment method!");
        }

        // Runtime polymorphism: selected class's pay() executes
        selectedMethod.pay(amount);

        payment newPayment = new payment(
            nextPaymentId++,
            orderId,
            amount,
            selectedMethod.getMethodName(),
            "SUCCESS"
        );

        repository.save(newPayment);
        return newPayment;
    }

    public List<payment> getAllPayments() {
        return repository.findall();
    }

    public payment getPaymentById(int paymentId) {
        return repository.findById(paymentId);
    }
}