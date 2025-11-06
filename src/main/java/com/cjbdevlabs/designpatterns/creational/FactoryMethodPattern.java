package com.cjbdevlabs.designpatterns.creational;

/*
Used to determine which concrete class should be created. Use Factory Method when a class to has to create instances
of another class, but it doesn't know in advance what the type of concrete class should be.
 */
public class FactoryMethodPattern {

    interface Ticket {

        int getPrice();

    }
}
