package com.rest.services;

import com.rest.models.bill;
import com.rest.models.order;
import com.rest.repository.billrepository;

import java.util.List;

public class billservice {

    private final billrepository repository;
    private int nextBillId = 1;

    public billservice() {
        repository = new billrepository();
    }

    public bill generateBill(order orderDetails) {

        if (orderDetails == null) {
            throw new IllegalArgumentException("Order not found!");
        }

        if (orderDetails.getitems().isEmpty()) {
            throw new IllegalArgumentException(
                "Cannot generate a bill for an empty order!"
            );
        }

        bill newBill = new bill(nextBillId++, orderDetails);

        repository.save(newBill);

        return newBill;
    }

    public List<bill> getAllBills() {
        return repository.findall();
    }

    public bill getBillById(int id) {
        return repository.findById(id);
    }
}