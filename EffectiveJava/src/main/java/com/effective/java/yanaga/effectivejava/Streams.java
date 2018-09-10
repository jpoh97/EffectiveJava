package com.effective.java.yanaga.effectivejava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Streams {

    // var varInteger = 42; doesn't work cuz its only must used inner methods, never like class properties

    private static String createSomething() {
        return "something";
    }

    private static final String[] strings =
            {"a", "7", "4", "2", "T", "c", "10", "h", "2"};

    private static Map<Integer, String> createMap() {
        var map = new TreeMap<Integer, String>(); // Other case to use var
        return map;
    }

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>(); // its better use var
        var varMap = new TreeMap<String, Integer>(); // A good example of var use
        var something = createSomething(); // A bad example, its not clear that something is a string type
        try (var buffer = new BufferedReader(new FileReader("file.txt"))) {
            /*
             * its a good example of var use, cuz u don't need to write the type in both sites (left and right)
             *  and ur code is most readable
              */
        } catch (IOException e) {
        }

        Stream.iterate(0, i -> i + 2);
        Integer integer = Stream.of(1, 2, 3, 4).reduce((x, y) -> x + y).orElse(-1); // print 10
        Optional<Integer> reduce = Stream.of(1, 2, 3, 4).reduce((x, y) -> x + y);
        reduce.orElse(5 * 5); // Equals to reduce.orElseGet(() -> 5 * 5);
        reduce.orElseGet(() -> 5 * 5); // Use orElseGet for execute lambda operation or orElseGet
        reduce.orElseThrow(() -> new IllegalStateException("exception message")); // Param is a supplier
        Stream.of(strings)
                .map(s -> s) // .map(Function.identity())
                .filter(s -> s.matches("\\d+")) // filter param is a predicate
                .map(Integer::parseInt)
                .forEach(System.out::println); // foreach is a consumer operation

        /*
        Stream.iterate(0, i -> i + 1)
                .forEach(VeryLongBusinessClassWithLotsOfOperations::veryLongMethodThatCreatesAFactoryBasedOnInteger);
         */
        var a = new VeryLongBusinessClassWithLotsOfOperations();
        Stream.iterate(0, i -> i + 1)
                .forEach(a::veryLongMethodThatCreatesAFactoryBasedOnInteger); // its most readable that copy class and method name
    }
}

/* Equals to Stream.iterate(0, i -> i + 2);
Stream.iterate(0, new UnaryOperator<Integer>() {
    @Override
    public Integer apply(Integer integer) {
        return integer + 2;
    }
});
*/

/* Equals to Stream.of(1, 2, 3, 4).reduce((x, y) -> x + y)
Stream.of(1, 2, 3, 4)
    .reduce(new BinaryOperator<Integer>() {
        @Override
        public Integer apply(Integer integer, Integer integer2) {
            return integer + integer2;
        }
    });
 */

/* Equals to reduce.orElseGet(() -> 5 * 5);
reduce.orElseGet(new Supplier<Integer>() {
        @Override
        public Integer get() {
            return 5 * 5;
        }
    });
 */

/* Equals to reduce.orElseThrow(() -> new IllegalStateException("exception message"));
reduce.orElseThrow(new Supplier<IllegalStateException>() {
        @Override
        public IllegalStateException get() {
            return new IllegalStateException("exception message");
        }
    });
 */