package com.cjbdevlabs.designpatterns.creational;

/*
Used to determine which concrete class should be created. Use Factory Method when a class to has to create instances
of another class, but it doesn't know in advance what the type of concrete class should be.
 */
public class FactoryMethodPattern {

    enum TicketType {
        BUS,
        TRAIN,
        PLANE
    }

    interface Ticket {

        int getPrice();

    }

    static class BusTicket implements Ticket {

        @Override
        public int getPrice() {
            return 3;
        }
    }

    static class TrainTicket implements Ticket {

        @Override
        public int getPrice() {
            return 4;
        }
    }

    static class PlaneTicket implements Ticket {

        @Override
        public int getPrice() {
            return 40;
        }
    }

    static class TicketMachine {

        Ticket createTicket(TicketType ticketType) {
            return switch (ticketType) {
                case BUS -> new BusTicket();
                case TRAIN -> new TrainTicket();
                case PLANE -> new PlaneTicket();
            };
        }
    }

    static class TicketOffice {

        private static final TicketMachine ticketMachine = new TicketMachine();

        public static void main(String[] args) {
            var busTicket = ticketMachine.createTicket(TicketType.BUS);
            System.out.println("One bus ticket purchased. The price is $" + busTicket.getPrice() + ".");
            var trainTicket = ticketMachine.createTicket(TicketType.TRAIN);
            System.out.println("One train ticket purchased. The price is $" + trainTicket.getPrice() + ".");
        }
    }
}
