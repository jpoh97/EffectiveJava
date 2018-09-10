package com.effective.java.yanaga.effectivejava;

import java.time.Instant;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReferences {

    public static void main(String[] args) {
        st(Integer::parseInt); // st(s -> Integer.parseInt(s));
        bound(Instant.now()::isAfter); // bound(i -> Instant.now().isAfter(i));
        bound(instant -> getNOW().isAfter(instant));
        bound(getNOW()::isAfter);
        unbound(String::toLowerCase); // unbound(s -> s.toLowerCase());
        constructor(TreeMap::new); // constructor(() -> new TreeMap<>());
        array(int[]::new); // array(i -> new int[i]);
    }

    private static final Instant NOW = Instant.now();

    public static Instant getNOW() {
        return NOW;
    }

    public static void st(Function<String, Integer> function) {
    }

    public static void bound(Predicate<Instant> predicate) {
    }

    public static void unbound(UnaryOperator<String> operator) {
    }

    public static void constructor(Supplier<TreeMap<String, String>> supplier) {
    }

    public static void array(Function<Integer, int[]> function) {
    }
}
