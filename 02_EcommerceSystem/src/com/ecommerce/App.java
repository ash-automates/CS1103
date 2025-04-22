package com.ecommerce;

import com.ecommerce.orders.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Main program to demonstrate e-commerce functionality.
 */
public class App {

    public static void main(String[] args) {
        // Create some sample products for the store
        Product product1 = new Product("P001", "Laptop", 999.99);
        Product product2 = new Product("P002", "Smartphone", 599.99);
        Product product3 = new Product("P003", "Headphones", 49.99);

        // Add them to a list (product catalog)
        List<Product> productCatalog = new ArrayList<>();
        productCatalog.add(product1);
        productCatalog.add(product2);
        productCatalog.add(product3);

        // Create a customer
        Customer customer = new Customer("C001", "John Doe");

        // Customer browses and adds products to the shopping cart
        customer.addProductToCart(product1); // John adds the laptop
        customer.addProductToCart(product2); // John adds the smartphone

        // Display customer's shopping cart
        customer.displayCart();

        // Create an order from the customer's cart
        Order order = new Order("O001", customer, customer.getCart());

        // Generate order summary
        order.generateOrderSummary();

        // Let's say the order status is updated
        order.updateOrderStatus("Shipped");
    }
}

