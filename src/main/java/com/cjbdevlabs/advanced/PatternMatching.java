package com.cjbdevlabs.advanced;

public class PatternMatching {

    /*
    -- Add to main method to execute --

    var product1 = new FoodItem("burger", 3.50);
    var product2 = new DrinkItem("soda", 2.50);
    logDetails(product1);
    logDetails(product2);
     */

    record FoodItem(String name, double price) implements Item { }
    record DrinkItem(String name, double price) implements Item { }
    interface Item { }

    // record pattern matching with switch pattern matching
    private static void logDetails(Item item) {
        switch (item) {
            case FoodItem(String name, double price) -> System.out.printf("The food item is: %s, and the price is: %3.2f%n", name, price);
            case DrinkItem(String name, double price) -> System.out.printf("The drink item is: %s, and the price is: %3.2f", name, price);
            default -> System.out.println("Item not found");
        }
    }
}
