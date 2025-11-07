package com.cjbdevlabs.designpatterns.creational;

/*
Group related classes together. System should be independent of how objects are created.
Configured one of multiple families of objects. Family of related objects should be used together.
There is a complex class hierarchy. Concrete classes are isolated from client.
Easy to unit test.
 */
public class AbstractFactoryPattern {

    interface BikeFactory {

        Handlebars createHandlebars();
        Pedals createPedals();
        Tire createTire();
    }

     interface Handlebars {

        String getType();
    }

     interface Pedals {

        String getType();
    }

     interface Tire {

        int getWidth();
    }

    static class RoadBikeFactory implements BikeFactory {

        @Override
        public Handlebars createHandlebars() {
            return null;
        }

        @Override
        public Pedals createPedals() {
            return null;
        }

        @Override
        public Tire createTire() {
            return null;
        }
    }

     class RoadBikeHandlebars implements Handlebars {

        @Override
        public String getType() {
            return "DROP";
        }
    }

     class RoadBikePedals implements Pedals {

        @Override
        public String getType() {
            return "SPD-SL";
        }
    }

     class RoadBikeTire implements Tire {

        @Override
        public int getWidth() {
            return 23;
        }
    }

     static class MountainBikeFactory implements BikeFactory {

        @Override
        public Handlebars createHandlebars() {
            return null;
        }

        @Override
        public Pedals createPedals() {
            return null;
        }

        @Override
        public Tire createTire() {
            return null;
        }
    }

    class MountainBikeHandlebars implements Handlebars {

        @Override
        public String getType() {
            return "FLAT";
        }
    }

    class MountainBikePedals implements Pedals {

        @Override
        public String getType() {
            return "SPD";
        }
    }

    class MountainBikeTire implements Tire {

        @Override
        public int getWidth() {
            return 29;
        }
    }

    static class Bike {

        private Handlebars handlebars;
        private Pedals pedals;
        private Tire frontTire;
        private Tire backTire;

        public Bike(Handlebars handlebars, Pedals pedals, Tire frontTire, Tire backTire) {
            this.handlebars = handlebars;
            this.pedals = pedals;
            this.frontTire = frontTire;
            this.backTire = backTire;
        }

        public Handlebars getHandlebars() {
            return handlebars;
        }

        public Pedals getPedals() {
            return pedals;
        }

        public Tire getFrontTire() {
            return frontTire;
        }

        public Tire getBackTire() {
            return backTire;
        }

        @Override
        public String toString() {
            return "Bike{" +
                    "handlebars=" + handlebars.getType() +
                    ", pedals=" + pedals.getType() +
                    ", frontTire=" + frontTire.getWidth() +
                    ", backTire=" + backTire.getWidth() +
                    '}';
        }
    }

    static class BikeManufacturer {

        public static void main(String[] args) {
            Bike roadBike = buildBike("ROAD");
            Bike mountainBike = buildBike("MOUNTAIN");
            System.out.println(roadBike);
            System.out.println(mountainBike);
        }

        private static Bike buildBike(String bikeType) {
            if (bikeType.equalsIgnoreCase("ROAD")) {
                var roadBikeFactory = new RoadBikeFactory();
                var handlebars = roadBikeFactory.createHandlebars();
                var pedals = roadBikeFactory.createPedals();
                var frontTire = roadBikeFactory.createTire();
                var backTire = roadBikeFactory.createTire();
                return new Bike(handlebars, pedals, frontTire, backTire);
            } else if (bikeType.equalsIgnoreCase("MOUNTAIN")) {
                var mountainBikeFactory = new MountainBikeFactory();
                var handlebars = mountainBikeFactory.createHandlebars();
                var pedals = mountainBikeFactory.createPedals();
                var frontTire = mountainBikeFactory.createTire();
                var backTire = mountainBikeFactory.createTire();
                return new Bike(handlebars, pedals, frontTire, backTire);
            } else {
                throw new IllegalArgumentException("Bike type not supported");
            }
        }
    }
}
