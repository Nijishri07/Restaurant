
package com.rest.CLI;

import com.rest.models.order;
import com.rest.models.menuitem;
import com.rest.services.orderservice;
import com.rest.services.menuitemservice;

import java.util.List;
import java.util.Scanner;

public class ordercli {

    private final orderservice orderService;
    private final menuitemservice menuService;
    private final Scanner scanner = new Scanner(System.in);

    public ordercli(orderservice orderService,
                    menuitemservice menuService) {
        this.orderService = orderService;
        this.menuService = menuService;
    }

    public void start() {

        System.out.println("\n=== ORDER MANAGEMENT ===");

        List<menuitem> menuItems =
                menuService.getAllMenuItems();

        System.out.println("\n=== MENU ===");

        for (menuitem item : menuItems) {
            System.out.println(
                item.getid() + ". " +
                item.getname() + " - Rs. " +
                item.getprice()
            );
        }

        System.out.print("\nEnter Table ID: ");
        int tableId = Integer.parseInt(scanner.nextLine());

        order currentOrder =
                orderService.createOrder(tableId);

        while (true) {

            System.out.print(
                "\nEnter Menu Item ID (0 to finish): "
            );

            int itemId =
                    Integer.parseInt(scanner.nextLine());

            if (itemId == 0) {
                break;
            }

            menuitem selectedItem = null;

            for (menuitem item : menuItems) {
                if (item.getid() == itemId) {
                    selectedItem = item;
                    break;
                }
            }

            if (selectedItem == null) {
                System.out.println("Invalid Menu Item ID!");
                continue;
            }

            System.out.print("Enter Quantity: ");
            int quantity =
                    Integer.parseInt(scanner.nextLine());

            if (quantity <= 0) {
                System.out.println(
                    "Quantity must be greater than zero!"
                );
                continue;
            }

            orderService.addItemToOrder(
                currentOrder,
                selectedItem,
                quantity
            );

            System.out.println(
                selectedItem.getname()
                + " added! Quantity: " + quantity
            );
        }

        if (currentOrder.getitems().isEmpty()) {
            System.out.println("No items added to the order.");
            return;
        }

        System.out.println("\n=== ORDER SUMMARY ===");

        for (var item : currentOrder.getitems()) {
            System.out.println(item);
        }

        System.out.println(
            "Total Amount: Rs. "
            + currentOrder.gettotalAmount()
        );
    }
}
