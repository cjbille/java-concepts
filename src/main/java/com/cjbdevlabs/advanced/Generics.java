package com.cjbdevlabs.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {

    /*
    -- Add to main method to execute --

    Box<Book> bookBox = new Box<>();
    bookBox.addItem(new Book("Harry Potter and the Prisoner of Azkaban", "JK Rowling", 0.5));
    bookBox.addItem(new Book("Game of Thrones", "George RR Marting", 0.5));
    System.out.println(bookBox.getLatestItem());
    System.out.println(bookBox);
    System.out.printf("Book box total weight: %s\n", bookBox.getTotalWeight());

    Box<Fruit> fruitBox = new Box<>();
    fruitBox.addItem(new Fruit("Mango", "India", "Yellow", 0.5));
    System.out.println(fruitBox.getLatestItem());
    System.out.println(fruitBox);
    System.out.printf("Fruit box total weight: %s\n", fruitBox.getTotalWeight());


    System.out.printf("Book box count: %s\n", BoxUtils.getCountOfItems(bookBox));
    System.out.printf("Fruit box count: %s", BoxUtils.getCountOfItems(fruitBox));

    Integer[] someArray = { 1, 2, 3, 4 };
    var list = convertArrayToList(someArray);
    System.out.println(list);
     */

    // generic method
    private static <T> List<T> convertArrayToList(T[] array) {
        return Arrays.asList(array);
    }

    interface Boxable {

        double getWeight();
    }

    static class Box<T extends Boxable> {
        private List<T> items;

        public Box() {
            this.items = new ArrayList<>();
        }

        public void addItem(T t) {
            this.items.add(t);
        }

        public T getLatestItem() {
            return this.items.getLast();
        }

        public List<T> getItems() {
            return items;
        }

        public double getTotalWeight() {
            return this.items
                    .stream()
                    .mapToDouble(Boxable::getWeight)
                    .sum();
        }

        @Override
        public String toString() {
            return "Box{" +
                    "items=" + items +
                    '}';
        }
    }

    static class Book implements Boxable {

        private String name;
        private String author;
        private double weight;

        public Book(String name, String author, double weight) {
            this.name = name;
            this.author = author;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public String getAuthor() {
            return author;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    static class Fruit implements Boxable {

        private String name;
        private String countryOfOrigin;
        private String color;
        private double weight;

        public Fruit(String name, String countryOfOrigin, String color, double weight) {
            this.name = name;
            this.countryOfOrigin = countryOfOrigin;
            this.color = color;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public String getCountryOfOrigin() {
            return countryOfOrigin;
        }

        public String getColor() {
            return color;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Fruit{" +
                    "name='" + name + '\'' +
                    ", countryOfOrigin='" + countryOfOrigin + '\'' +
                    ", color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    static class BoxUtils {

        // Generic method outside of generic class
        public static <T extends Boxable> int getCountOfItems(Box<T> box) {
            return box.getItems().size();
        }
    }
}
