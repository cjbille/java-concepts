package com.cjbdevlabs.designpatterns.behavioral;

import java.util.Iterator;

/*
Provides a way to access elements in a collection
 */
public class IteratorPattern {


    static class App {

        public static void main(String[] args) {
            var pen = new Item("Pen", 20);
            var pencil = new Item("Pencil", 0);
            var eraser = new Item("Eraser", 15);

            var inventory = new Inventory(pen, pencil, eraser);
            var stockIterator = inventory.iterator();

            while (stockIterator.hasNext()) {
                var item = stockIterator.next();
                System.out.println(item.getName());
            }
        }
    }

    static class Item {

        private final String name;
        private final int quantity;

        public Item(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return this.name;
        }


        public int getQuantity() {
            return this.quantity;
        }
    }

    static class Inventory implements Iterable<Item> {

        private final Item[] items;

        public Inventory(Item... items) {
            this.items = items;
        }

        public Item[] getItems() {
            return this.items;
        }

        @Override
        public Iterator<Item> iterator() {
            return null;
        }
    }

    static class StockIterator implements Iterator<Item> {

        private Inventory inventory;
        private int index;

        public StockIterator(Inventory inventory) {
            this.inventory = inventory;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            var items = inventory.getItems();
            return index < items.length;
        }

        @Override
        public Item next() {
            var items = inventory.getItems();
            if (hasNext()) {
                var item = items[index++];
                if (item.getQuantity() > 0) {
                    return item;
                } else {
                    return next();
                }
            } else {
                return null;
            }
        }
    }
}
