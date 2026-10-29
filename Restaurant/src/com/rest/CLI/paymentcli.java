package com.rest.CLI;

import com.rest.models.payment;
import com.rest.payment.*;
import com.rest.services.paymentservice;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class paymentcli {

    private final paymentservice service;
    private final Scanner scanner = new Scanner(System.in);

    public paymentcli() {
        service = new paymentservice();
    }

    public void start() {

        int choice = -1;

        do {
            System.out.println("\n=== RESTAURANT PAYMENT SYSTEM ===");
            System.out.println("1. Make Payment");
            System.out.println("2. View All Payments");
            System.out.println("3. Find Payment by ID");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        makePayment();
                        break;

                    case 2:
                        viewAllPayments();
                        break;

                    case 3:
                        findPayment();
                        break;

                    case 0:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                choice = -1;
            }

        } while (choice != 0);
    }

    private void makePayment() {

        try {
            System.out.print("Enter Order ID: ");
            int orderId = scanner.nextInt();

            if (orderId <= 0) {
                System.out.println("Order ID must be greater than zero!");
                return;
            }

            System.out.print("Enter payment amount: ");
            double amount = scanner.nextDouble();

            if (amount <= 0) {
                System.out.println("Amount must be greater than zero!");
                return;
            }

            System.out.println("\nSelect Payment Method:");
            System.out.println("1. Cash");
            System.out.println("2. Card");
            System.out.println("3. UPI");
            System.out.print("Enter choice: ");

            int methodChoice = scanner.nextInt();

            paymentmethod method;

            switch (methodChoice) {
                case 1:
                    method = new cashPayment();
                    break;

                case 2:
                    method = new cardPayment();
                    break;

                case 3:
                    method = new upiPayment();
                    break;

                default:
                    System.out.println("Invalid payment method!");
                    return;
            }

            payment newPayment =
                    service.processPayment(orderId, amount, method);

            System.out.println("\nPayment recorded successfully!");
            System.out.println(newPayment);

        } catch (InputMismatchException e) {
            System.out.println("Please enter valid numeric values.");
        } finally {
            scanner.nextLine();
        }
    }

    public void viewAllPayments() {

        List<payment> payments = service.getAllPayments();

        System.out.println("\n=== ALL PAYMENTS ===");

        if (payments.isEmpty()) {
            System.out.println("No payments found.");
            return;
        }

        for (payment p : payments) {
            System.out.println(p);
        }
    }

    private void findPayment() {

        try {
            System.out.print("Enter Payment ID: ");
            int id = scanner.nextInt();

            payment p = service.getPaymentById(id);

            if (p == null) {
                System.out.println("Payment not found!");
            } else {
                System.out.println("\n=== PAYMENT DETAILS ===");
                System.out.println(p);
            }

        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid Payment ID.");
        } finally {
            scanner.nextLine();
        }
    }
}