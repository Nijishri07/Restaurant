
package com.rest.CLI;

import com.rest.models.order;
import com.rest.models.bill;
import com.rest.services.orderservice;
import com.rest.services.billservice;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class billcli {

    private final orderservice orderService;
    private final billservice billService;
    private final Scanner scanner;

    public billcli(orderservice orderService,
                   billservice billService,
                   Scanner scanner) {
        this.orderService = orderService;
        this.billService = billService;
        this.scanner = scanner;
    }

    public void start() {

        List<order> orders = orderService.getAllOrders();

        if (orders.isEmpty()) {
            System.out.println(
                "No orders found. Please place an order first."
            );
            return;
        }

        System.out.println("\n===== GENERATE BILL =====");

        for (order o : orders) {
            System.out.println(
                "Order ID: " + o.getid()
                + " | Total: Rs. " + o.gettotalAmount()
            );
        }

        try {
            System.out.print("\nEnter Order ID to generate bill: ");
            int orderId = scanner.nextInt();
            scanner.nextLine();

            order selectedOrder = null;

            for (order o : orders) {
                if (o.getid() == orderId) {
                    selectedOrder = o;
                    break;
                }
            }

            if (selectedOrder == null) {
                System.out.println("Invalid Order ID!");
                return;
            }

            bill newBill = billService.generateBill(selectedOrder);
            System.out.println(newBill);

        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid numeric Order ID.");
            scanner.nextLine();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewAllBills() {

        List<bill> bills = billService.getAllBills();

        System.out.println("\n===== ALL BILLS =====");

        if (bills.isEmpty()) {
            System.out.println("No bills found.");
            return;
        }

        for (bill b : bills) {
            System.out.println(b);
        }
    }

    public void findBill() {

        try {
            System.out.print("Enter Bill ID: ");
            int billId = scanner.nextInt();
            scanner.nextLine();

            bill foundBill = billService.getBillById(billId);

            if (foundBill == null) {
                System.out.println("Bill not found!");
            } else {
                System.out.println(foundBill);
            }

        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid Bill ID.");
            scanner.nextLine();
        }
    }
}
