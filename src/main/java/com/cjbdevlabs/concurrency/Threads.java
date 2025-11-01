package com.cjbdevlabs.concurrency;

public class Threads {

    /*
    -- Add to main method to execute --

    System.out.println("Starting main thread: " + Thread.currentThread().getName());
    System.out.println("Is daemon thread? " + Thread.currentThread().isDaemon());

    var firstThread = new FirstThread();
    firstThread.setName("firstThread");
    firstThread.start();

    var firstRunnable = new FirstRunnable();
    var firstRunnableThread = new Thread(firstRunnable);
    firstRunnableThread.setName("firstRunnableThread");
    firstRunnableThread.start();
     */

    static class FirstThread extends Thread {
        @Override
        public void run() {
            System.out.println("Running a my first thread that extends thread class with thread name: " + Thread.currentThread().getName());
            for (var i = 1; i < 5; i++) {
                System.out.println("Thread " + i);
            }
        }
    }

    static class FirstRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Running a my first thread that implements runnable interface with thread name: " + Thread.currentThread().getName());
            for (var i = 1; i < 5; i++) {
                System.out.println("Runnable " + i);
            }
        }
    }
}
