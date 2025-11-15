package com.cjbdevlabs.designpatterns.behavioral;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/*
Objects working or observing other objects. Use when one or more objects need to be notified about changes
 */
public class ObserverPattern {

    static class App {

        public static void main(String[] args) {

            var user1 = new User();
            var user2 = new User();
            var newsfeed = new Newsfeed();
            user1.addPropertyChangeListener(newsfeed);
            user2.addPropertyChangeListener(newsfeed);

            user1.setStatus("Going for a walk");
            user2.setStatus("Enjoying a coffee");

            newsfeed.printStatuses();
        }
    }

    static class Newsfeed implements PropertyChangeListener {

        private List<String> statuses = new ArrayList<>();

        public void printStatuses() {
            statuses.forEach(System.out::println);
        }

        @Override
        public void propertyChange(PropertyChangeEvent event) {
            statuses.add((String) event.getNewValue());
        }
    }

    static class User {

        private String status;
        private PropertyChangeSupport support = new PropertyChangeSupport(this);

        public void setStatus(String status) {
            support.firePropertyChange("status", this.status, status);
            this.status = status;
        }

        public void addPropertyChangeListener(Newsfeed newsfeed) {
            support.addPropertyChangeListener(newsfeed);
        }
    }
}
