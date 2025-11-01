package com.cjbdevlabs.concurrency;

public class ThreadPools {

    /*
    -- Add to main method to execute --

    var numberOfProcessors = Runtime.getRuntime().availableProcessors();
    System.out.println("Number of processors: " + numberOfProcessors);
    var pool =  Executors.newFixedThreadPool(numberOfProcessors);
    for  (int i = 1; i <= 100; i++) {
        var veggieChopperThread = new Thread(new VegetableChopper());
        pool.submit(veggieChopperThread);
    }
    pool.shutdown();
     */

    public static class VegetableChopper implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " chopped a vegetable");
        }
    }
}
