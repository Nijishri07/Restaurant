
package com.rest.services;

import com.rest.models.orderitem;
import com.rest.models.menuitem;
import com.rest.repository.orderitemrepository;
import java.util.List;

public class orderitemservice {

    private final orderitemrepository repository;
    private int nextId = 1;

    public orderitemservice() {
        repository = new orderitemrepository();
    }

    public orderitem createOrderItem(menuitem item, int quantity) {

        if (item == null) {
            throw new IllegalArgumentException("Menu item cannot be null");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        orderitem newItem = new orderitem(nextId++, item, quantity);
        repository.save(newItem);

        return newItem;
    }

    public List<orderitem> getAllOrderItems() {
        return repository.findall();
    }
}
