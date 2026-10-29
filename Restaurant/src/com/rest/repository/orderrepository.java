package com.rest.repository;

import com.rest.models.order;
import java.util.ArrayList;
import java.util.List;

public class orderrepository {

    private final List<order> orders = new ArrayList<>();

    public void save(order newOrder) {
        orders.add(newOrder);
    }

    public List<order> findall() {
        return orders;
    }
}