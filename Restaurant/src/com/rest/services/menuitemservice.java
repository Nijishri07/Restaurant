
package com.rest.services;

import com.rest.models.menuitem;
import com.rest.repository.menuitemrepository;
import java.util.List;

public class menuitemservice {

    private final menuitemrepository repository;

    public menuitemservice() {
        repository = new menuitemrepository();
    }

    public List<menuitem> getAllMenuItems() {
        return repository.findall();
    }
}
