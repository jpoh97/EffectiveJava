package com.effective.java.yanaga.effectivejava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {

    private final Date date;
    private final List<OrderItem> items;

    private Order(Date date, List<OrderItem> items) {
        this.date = date;
        this.items = items;
    }

    public static Order of(Date date, List<OrderItem> items) {
        Objects.requireNonNull(date);
        return new Order(new Date(date.getTime()), new ArrayList<>(items));
        // create a copy of date param cuz Date is mutable, this technique is called defensive copy
    }

    public Date getDate() {
        return new Date(date.getTime()); // defensive copy
    }

    public List<OrderItem> getItems() {
        return ImmutableList.copyOf(items); // Another way to create a defensive copy
        // if other class try to modify the items, it would be have a unsupported operation exception
    }
}
