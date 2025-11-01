package com.cjbdevlabs.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Functional {

    /*
    -- Add to main method to execute --

    System.out.println(Functions.tripleValueFunc.apply(3));
    System.out.println(Functions.addValuesFunc.apply(8, 90));
    System.out.println(Functions.multipylyValuesFunc.apply(24, 74, 38));
    System.out.println(Functions.noArgFunction.apply());
    System.out.println(Functions.greeterFunc.apply());

    int[] arrayOfInts = { 1, 2, 3, 4, 5, 6, 7 };
    List<Integer> listOfInts = Arrays.stream(arrayOfInts).boxed().toList();
    var doubleListOfInts = listOfInts.stream().map(x -> x * 2).toList();

    BinaryOperator<Integer> getSum = (acc, x) -> {
        var result = acc + x;
        System.out.println("acc: " + acc + ", x: " + x + ", result: " + result);
        return result;
    };

    // reduce
    Integer sum = listOfInts.stream().reduce(0, getSum);
    System.out.println("The sum is: " + sum);

    // recursion
    Functions.countDown(10);
     */

    /**
     * Class and package refer to functional programming within the java language
     * Functional programming concepts
     * <ul>
     *     <li>Immutability</li>
     *     <li>Functional purity</li>
     *     <li>First class functions</li>
     * </ul>
     * Define functions with the {@link java.util.function.Function} interface - Note that the Function interface
     * can only create functions that accept one argument.
     * Can use the {@link java.util.function.BiFunction} interface to create functions that accept two arguments
     */
    class Functions {

        public static Function<Integer, Integer> tripleValueFunc = x -> x * 3;
        public static BiFunction<Integer, Integer, Integer> addValuesFunc = (x, y) -> x + y;
        public static TriFunction<Integer, Integer, Integer, Integer> multipylyValuesFunc = (x, y, z) -> x * y * z;
        public static NoArgFunction<String> noArgFunction = () -> "hello no args!";
        public static NoArgFunction<NoArgFunction<String>> createGreaterFunc = () -> {
            var name = "Chris";
            return () -> "Hello " + name;
        };
        public static NoArgFunction<String> greeterFunc = createGreaterFunc.apply();

        public static void countDown(Integer x) {
            if (x < 0) {
                System.out.println("Done count down!");
                return;
            }
            System.out.println("The count is: " + x);
            countDown(x - 1);
        }
    }

    @FunctionalInterface
    interface NoArgFunction<R> {

        R apply();
    }

    @FunctionalInterface
    public interface TriFunction<T, U, V, R> {

        /**
         * Applies this function to the given argument.
         *
         * @param t the function argument
         * @param u the function argument
         * @param v the function argument
         * @return the function result
         */
        R apply(T t, U u, V v);
    }
}
