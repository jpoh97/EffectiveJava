package com.effective.java.yanaga.effectivejava;

import com.google.common.collect.MoreCollectors;

import java.util.Map;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {
    ADD(Addition::add, "A"),
    SUBTRACT((x, y) -> x - y, "S"),
    MULTIPLY((x, y) -> x * y, "M"),
    DIVIDE((x, y) -> x / y, "D");

    private static final Map<String, Operation> VALUE_MAP = Stream.of(values())
            .collect(Collectors.toMap(o -> o.databaseValue, o -> o));

    private final IntBinaryOperator operator;
    private final String databaseValue;

    Operation(IntBinaryOperator operator, String databaseValue) {
        this.operator = operator;
        this.databaseValue = databaseValue;
    }

    public static Optional<Operation> fromString(String databaseValue) {
        return Optional.ofNullable(VALUE_MAP.get(databaseValue)); // never return null, its dumbest cuz nullpointerexception
    }

    /*
    public static Operation fromString(String databaseValue) {
        return VALUE_MAP.getOrDefault(databaseValue, Operation.ADD);
    }
    */

    public String toDatabaseValue() {
        return databaseValue;
    }
}
/*
Old way for apply strategy pattern in enums
public enum Operation {
    ADD {
        @Override
        public int apply(int x, int y) {
            return x + y;
        }
    },
    SUBTRACT {
        @Override
        public int apply(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY {
        @Override
        public int apply(int x, int y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        public int apply(int x, int y) {
            return x / y;
        }
    };

    public abstract int apply(int x, int y);
}
*/