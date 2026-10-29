
package com.rest.repository;

import com.rest.models.menuitem;
import java.util.ArrayList;
import java.util.List;

public class menuitemrepository {

    private final List<menuitem> menuitems = new ArrayList<>();

    public menuitemrepository() {
        menuitems.add(new menuitem(1, "Pizza", 200, "Main Course"));
        menuitems.add(new menuitem(2, "Burger", 120, "Fast Food"));
        menuitems.add(new menuitem(3, "Juice", 80, "Drinks"));
    }

    public List<menuitem> findall() {
        return menuitems;
    }
}
