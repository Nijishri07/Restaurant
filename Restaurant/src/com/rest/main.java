
package com.rest;

import com.rest.CLI.tablecli;
import com.rest.CLI.menuitemcli;
import com.rest.CLI.ordercli;
import com.rest.CLI.paymentcli;
import com.rest.CLI.billcli;

import com.rest.services.tableservice;
import com.rest.services.menuitemservice;
import com.rest.services.orderservice;
import com.rest.services.billservice;

import com.rest.models.order;

import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        tableservice tableService = new tableservice();
        menuitemservice menuService = new menuitemservice();
        orderservice orderService = new orderservice();
        billservice billService = new billservice();

        tablecli tableCLI = new tablecli(tableService);
        menuitemcli menuCLI = new menuitemcli(menuService);

        ordercli orderCLI = new ordercli(
            orderService, menuService
        );

        paymentcli paymentCLI = new paymentcli();

        billcli billCLI = new billcli(
            orderService, billService, scanner
        );

        int choice = -1;

        do {
            System.out.println(
                "\n===== RESTAURANT MANAGEMENT SYSTEM ====="
            );
            System.out.println("1. View All Tables");
            System.out.println("2. View Menu Items");
            System.out.println("3. Place Order");
            System.out.println("4. View All Orders");
            System.out.println("5. Make Payment");
            System.out.println("6. View All Payments");
            System.out.println("7. Generate Bill");
            System.out.println("8. View All Bills");
            System.out.println("9. Find Bill by ID");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        tableCLI.start();
                        break;

                    case 2:
                        menuCLI.start();
                        break;

                    case 3:
                        orderCLI.start();
                        break;

                    case 4:
                        List<order> orders =
                            orderService.getAllOrders();

                        System.out.println("\n===== ALL ORDERS =====");

                        if (orders.isEmpty()) {
                            System.out.println("No orders found.");
                        } else {
                            for (order o : orders) {
                                System.out.println(o);
                            }
                        }
                        break;

                    case 5:
                        paymentCLI.start();
                        break;

                    case 6:
                        paymentCLI.viewAllPayments();
                        break;

                    case 7:
                        billCLI.start();
                        break;

                    case 8:
                        billCLI.viewAllBills();
                        break;

                    case 9:
                        billCLI.findBill();
                        break;

                    case 0:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
