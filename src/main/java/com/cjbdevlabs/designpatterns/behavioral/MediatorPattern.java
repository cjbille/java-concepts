package com.cjbdevlabs.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/*
Acts as a neutral party so other don't hve to speak to each other directly
 */
public class MediatorPattern {

    static class Ticket {

        private Assignee assignee;
        public enum Status {
            SUBMITTED,
            IN_PROGRESS,
            DONE
        }

        private Status status;

        public Ticket() {
            this.status = Status.SUBMITTED;
        }

        public Status getStatus() {
            return this.status;
        }

        public void setStatus(Status status) {
            this.status = status;
            System.out.println("Ticket status changed to " + status);
        }

        public void setAssignee(Assignee assignee) {
            this.assignee = assignee;
        }
    }

    static class Board {

        private List<Ticket> inProgressTickets = new ArrayList<>();
        private List<Ticket> doneTickets = new ArrayList<>();

        public List<Ticket> getDoneTickets() {
            return this.doneTickets;
        }

        public void addTicketToInProgressTickets(Ticket ticket) {
            inProgressTickets.add(ticket);
            System.out.println("Ticket added to inProgressTickets");
        }

        public void addTicketToDoneTickets(Ticket ticket) {
            doneTickets.add(ticket);
            System.out.println("Ticket added to doneTickets");
            inProgressTickets.remove(ticket);
            System.out.println("Ticket removed from inProgressTickets");
        }
    }

    static class Assignee {

        private List<Ticket> tickets = new ArrayList<>();

        public void pickUpTicket(Ticket ticket) {
            System.out.println("Ticket picked up by assignee");
            tickets.add(ticket);
        }

        public void resolveTicket(Ticket ticket) {
            tickets.remove(ticket);
            System.out.println("Ticket resolved");
        }
    }

    static class Mediator {

        private Ticket ticket;
        private Board board;
        private Assignee assignee;

        public Mediator(Ticket ticket, Board board, Assignee assignee) {
            this.ticket = ticket;
            this.board = board;
            this.assignee = assignee;
        }

        public void pickupTicket() {
            assignee.pickUpTicket(ticket);
            ticket.setAssignee(assignee);
            ticket.setStatus(Ticket.Status.IN_PROGRESS);
            board.addTicketToInProgressTickets(ticket);
        }

        public void resolveTicket() {
            assignee.resolveTicket(ticket);
            ticket.setStatus(Ticket.Status.DONE);
            board.addTicketToDoneTickets(ticket);
        }
    }

    static class App {

        public static void main(String[] args) {
            var board = new Board();
            var ticket = new Ticket();
            var assignee = new Assignee();
            var mediator = new Mediator(ticket, board, assignee);

            mediator.pickupTicket();
            System.out.println();
            mediator.resolveTicket();
        }
    }
}
