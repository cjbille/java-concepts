package com.cjbdevlabs.designpatterns.behavioral;

/*
Use composition over inheritance
 */
public class BridgePattern {

     interface ClothingItem {

        void getType();
        Size getSize();
     }

     interface Size {
        void get();
    }

    static class AdultSize implements Size {

        @Override
        public void get() {
            System.out.println("Adult");
        }
    }

    static class ChildSize implements Size {

        @Override
        public void get() {
            System.out.println("Child");
        }
    }

    static class Hoodie implements ClothingItem {

         private final Size size;

         public Hoodie(Size size) {
             this.size = size;
         }

        @Override
        public void getType() {
            System.out.println("Hoodie");
        }

        @Override
        public Size getSize() {
             return size;
        }
    }

    static class Shirt implements ClothingItem {

        private final Size size;

        public Shirt(Size size) {
            this.size = size;
        }

        @Override
        public void getType() {
            System.out.println("Shirt");
        }

        @Override
        public Size getSize() {
            return size;
        }
    }

    static class App {

        public static void main(String[] args) {
            var hoodie = new Hoodie(new ChildSize());
            hoodie.getType();
            hoodie.getSize().get();

            var shirt = new Shirt(new AdultSize());
            shirt.getType();
            shirt.getSize().get();
        }
    }
}
