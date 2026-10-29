
package com.rest.services;

import com.rest.models.order;
import com.rest.models.orderitem;
import com.rest.repository.orderrepository;

import java.util.List;

public class orderservice {

    private final orderrepository repository;
    private final orderitemservice itemService;
    private int nextOrderId = 1;

    public orderservice() {
        repository = new orderrepository();
        itemService = new orderitemservice();
    }

    public order createOrder(int tableId) {
        order newOrder = new order(nextOrderId++, tableId);
        repository.save(newOrder);
        return newOrder;
    }

    public void addItemToOrder(
            order currentOrder,
            com.rest.models.menuitem item,
            int quantity) {

        orderitem newItem =
                itemService.createOrderItem(item, quantity);

        currentOrder.additem(newItem);
    }

    public List<order> getAllOrders() {
        return repository.findall();
    }
}
