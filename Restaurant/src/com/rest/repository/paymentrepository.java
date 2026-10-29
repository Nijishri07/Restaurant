
package com.rest.repository;

import com.rest.models.payment;
import java.util.ArrayList;
import java.util.List;

public class paymentrepository {

    private final List<payment> payments = new ArrayList<>();

    public void save(payment Payment) {
        payments.add(Payment);
    }

    public List<payment> findall() {
        return new ArrayList<>(payments);
    }

    public payment findById(int id) {
        for (payment p : payments) {
            if (p.getid() == id) {
                return p;
            }
        }

        return null;
    }
}
