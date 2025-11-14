package com.cjbdevlabs.designpatterns.behavioral;

/*
A way of making requests when you don't know anything about what is exactly being requested
 */
public class CommandPattern {

    static class Item {

        private final int id;

        public Item(int id) {
            this.id = id;
        }

        public void addToBasket() {
            System.out.println("Item " + id + " added to basket.");
        }

        public void removeFromBasket() {
            System.out.println("Item " + id + " removed from basket.");
        }

    }

    static class OnlineStore {

        public static void main(String[] args) {
            var item1 = new Item(1);
            var item2 = new Item(2);
            var item3 = new Item(3);

            var itemOperationExecutor = new ItemOperationExecutor();
            itemOperationExecutor.doOperation(new AddItemToBasketOperation(item1));
            itemOperationExecutor.doOperation(new AddItemToBasketOperation(item2));
            itemOperationExecutor.doOperation(new AddItemToBasketOperation(item3));
            itemOperationExecutor.doOperation(new RemoveItemToBasketOperation(item1));
        }
    }

    interface ItemOperation {
        void execute();
    }

    static class AddItemToBasketOperation implements ItemOperation {

        private final Item item;

        public AddItemToBasketOperation(Item item) {
            this.item = item;
        }

        @Override
        public void execute() {
            item.addToBasket();
        }
    }

    static class RemoveItemToBasketOperation implements ItemOperation {

        private final Item item;

        public RemoveItemToBasketOperation(Item item) {
            this.item = item;
        }

        @Override
        public void execute() {
            item.addToBasket();
        }
    }

    static class ItemOperationExecutor {

        public void doOperation(ItemOperation itemOperation) {
            itemOperation.execute();
        }
    }
}
