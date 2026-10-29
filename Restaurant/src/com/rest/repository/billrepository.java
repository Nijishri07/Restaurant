package com.rest.repository;

import com.rest.models.bill;
import java.util.ArrayList;
import java.util.List;

public class billrepository {

    private final List<bill> bills = new ArrayList<>();

    public void save(bill newBill) {
        bills.add(newBill);
    }

    public List<bill> findall() {
        return new ArrayList<>(bills);
    }

    public bill findById(int id) {
        for (bill b : bills) {
            if (b.getbillId() == id) {
                return b;
            }
        }

        return null;
    }
}