
package com.rest.CLI;

import com.rest.models.menuitem;
import com.rest.models.orderitem;
import com.rest.services.menuitemservice;
import com.rest.services.orderitemservice;

import java.util.List;
import java.util.Scanner;

public class orderitemcli {

    private final orderitemservice service;
    private final menuitemservice menuService;
    private final Scanner scanner = new Scanner(System.in);

    public orderitemcli(orderitemservice service,
                        menuitemservice menuService) {
        this.service = service;
        this.menuService = menuService;
    }

    public void start() {

        List<menuitem> items = menuService.getAllMenuItems();

        System.out.println("\n=== MENU ITEMS ===");

        for (menuitem item : items) {
            System.out.println(
                item.getid() + ". " + item.getname()
                + " - Rs. " + item.getprice()
            );
        }

        System.out.print("Enter Menu Item ID: ");
        int itemId = Integer.parseInt(scanner.nextLine());

        menuitem selected = null;

        for (menuitem item : items) {
            if (item.getid() == itemId) {
                selected = item;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Invalid Menu Item ID!");
            return;
        }

        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        try {
            orderitem newItem = service.createOrderItem(selected, quantity);
            System.out.println("\n=== ORDER ITEM SUMMARY ===");
            System.out.println(newItem);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
