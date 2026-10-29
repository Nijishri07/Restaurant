
package com.rest.CLI;

import com.rest.models.menuitem;
import com.rest.services.menuitemservice;
import java.util.List;
import java.util.Scanner;

public class menuitemcli {

    private final menuitemservice service;
    private final Scanner scanner = new Scanner(System.in);

    public menuitemcli(menuitemservice service) {
        this.service = service;
    }

    public void start() {
        System.out.println("== RESTAURANT MENU MANAGEMENT ==");
        System.out.println("1. View All Menu Items");
        System.out.println("0. Exit");

        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            List<menuitem> items = service.getAllMenuItems();

            System.out.println("\n== ALL MENU ITEMS ==");

            for (menuitem item : items) {
                System.out.println(item);
            }
        } else if (choice == 0) {
            System.out.println("Thank you!");
        } else {
            System.out.println("Invalid choice");
        }
    }
}
