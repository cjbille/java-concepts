package com.cjbdevlabs.concurrency;

import java.util.concurrent.Callable;

public class Futures {

    /*
    -- Add to main method to execute --

    System.out.println("How many vegetables are in the pantry?");
    var executor = Executors.newSingleThreadExecutor();
    Future result = executor.submit(new HowManyVegetables());
    System.out.println("Waiting for the result");
    System.out.println("Finally got a response: " + result.get());
     */

    public static class HowManyVegetables implements Callable {
        @Override
        public Integer call() throws Exception {
            System.out.println("Counting vegetables");
            Thread.sleep(3000);
            return 42;
        }
    }
}
