
package com.rest.repository;

import com.rest.models.orderitem;
import java.util.ArrayList;
import java.util.List;

public class orderitemrepository {

    private final List<orderitem> orderItems = new ArrayList<>();

    public void save(orderitem item) {
        orderItems.add(item);
    }

    public List<orderitem> findall() {
        return orderItems;
    }
}
