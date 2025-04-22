package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private List<Product> cart;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.cart = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void addProductToCart(Product product) {
        cart.add(product);
    }

    public void removeProductFromCart(Product product) {
        cart.remove(product);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product product : cart) {
            total += product.getPrice();
        }
        return total;
    }

    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println(name + "'s Cart:");
            for (Product product : cart) {
                System.out.println(" - " + product);
            }
            System.out.printf("Total: $%.2f%n", calculateTotal());
        }
    }
}
