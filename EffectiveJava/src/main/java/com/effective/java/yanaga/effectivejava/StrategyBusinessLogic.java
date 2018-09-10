package com.effective.java.yanaga.effectivejava;

import com.google.common.base.Preconditions;

import java.util.Objects;
import java.util.function.IntUnaryOperator;

public class StrategyBusinessLogic {

    private final IntUnaryOperator operator;

    private StrategyBusinessLogic(IntUnaryOperator operator) {
        this.operator = operator;
    }

    public static StrategyBusinessLogic of(IntUnaryOperator operator) {
        Preconditions.checkNotNull(operator); // Objects.requireNonNull(operator); it's the same
        return new StrategyBusinessLogic(operator);
    }

    public void compute() {
        System.out.println("x");
        System.out.println("y");
        System.out.println("z");
        operator.applyAsInt(5);
        System.out.println("a");
        System.out.println("b");
        System.out.println("c");
    }

    public static void main(String[] args) {
        StrategyBusinessLogic.of(i -> i / 2);
        StrategyBusinessLogic.of(i -> i * 2);
        StrategyBusinessLogic.of(i -> i * 4);

        new TemplateBusinessLogic() {
            @Override
            protected void doSomething() {
                System.out.println("with template method instead strategy pattern");
            }
        }.compute();
    }
}
