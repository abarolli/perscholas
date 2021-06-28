package com.example;

import java.text.NumberFormat;

public class CartSystem extends TheSystem {
    public CartSystem() {
        
    }

    @Override
    public void display() {
        // Your code here

        System.out.println("Cart:");
        final String tableFormat = "%-20s %-20s %-10s %-10s %-10s";
        final String columns = String.format(tableFormat, "Name", "Description", "Price", "Quantity", "Sub Total");

        System.out.println(columns);

        double subTotal = calculateSubTotal();
        double tax = calculateTax();
        double total = calculateTotal();

        final String currencyFormat = "%.2f";
        for (Item item : getItemCollection().values()) {
            System.out.println(String.format(tableFormat,
                                             item.getItemName(), 
                                             item.getItemDesc(), 
                                             String.format(currencyFormat, item.getItemPrice()), 
                                             item.getQuantity(), 
                                             String.format(currencyFormat, subTotal)));
        }

        final String recieptFormat = "%-20s %-20s";
        System.out.println(String.format(recieptFormat, "Pre-tax Total", String.format(currencyFormat, subTotal)));
        System.out.println(String.format(recieptFormat, "Tax", String.format(currencyFormat, tax)));
        System.out.println(String.format(recieptFormat, "Total", String.format(currencyFormat, total)));
    }


    private double calculateSubTotal() {
        double subTotal = 0.0;

        for (Item item : getItemCollection().values()) {
            subTotal += (item.getItemPrice() * item.getQuantity());
        }

        return subTotal;
    }

    private double calculateTax() {
        return calculateSubTotal() * 0.05;
    }

    private double calculateTotal() {
        return calculateSubTotal() + calculateTax();
    }
}
