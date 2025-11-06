package com.cjbdevlabs.designpatterns.creational;

/*
Ensures there is only one instance of a class. Be careful, can be an anti-pattern if used incorrectly.
Use cases: database connections, access to config files, hardware resources, or loggers. Need to be careful about
threads. Known as an anti-pattern because it violates the single responsibility principle.
 */
public class SingletonPattern {

    enum PrintSpooler { // making an enum means it is thread safe since enums are thread safe by default in java
        INSTANCE;

        static PrintSpooler getInstance() {
            return INSTANCE;
        }

        void print() {
            System.out.println("printing...");
        }
    }

    static class DocumentPrinter {

        void printDocument() {
            var spooler = PrintSpooler.getInstance();
            spooler.print();
        }
    }

    static class ImagePrinter {

        void printImage() {
            var spooler = PrintSpooler.getInstance();
            spooler.print();
        }
    }
}
