package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import java.util.List;

/**
 * Represents an order placed by a customer.
 */
public class Order {

    private String orderID;
    private Customer customer; // Reference to the Customer object placing the order.
    private List<Product> products; // List of products in this order.
    private double orderTotal;
    private String status; // Order status (e.g., "Pending", "Shipped", "Delivered").

    /**
     * Constructor to create an Order object.
     */
    public Order(String orderID, Customer customer, List<Product> products) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = products;
        this.status = "Pending"; // Default order status is "Pending".
        this.orderTotal = calculateOrderTotal(); // Calculate the total when the order is created.
    }

    /**
     * Generates a summary of the order.
     * This method should display the order details: customer name, product list, and order total.
     */
    public void generateOrderSummary() {
        System.out.println("Order Summary:");
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Products in the order:");
        for (Product product : products) {
            System.out.println(" - " + product.getName() + ": $" + product.getPrice());
        }
        System.out.printf("Total: $%.2f%n", orderTotal);
        System.out.println("Status: " + status);
    }

    /**
     * Updates the status of the order.
     * This method should change the status of the order (e.g., from "Pending" to "Shipped").
     */
    public void updateOrderStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Order status updated to: " + newStatus);
    }

    /**
     * Calculates the total cost of the order.
     * This method should iterate through all products in the order and calculate the total price.
     */
    private double calculateOrderTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice(); // Add the price of each product to the total.
        }
        return total;
    }

    // Getters and Setters
    public String getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public String getStatus() {
        return status;
    }
}
