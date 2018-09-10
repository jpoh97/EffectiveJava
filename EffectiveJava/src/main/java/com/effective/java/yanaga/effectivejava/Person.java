package com.effective.java.yanaga.effectivejava;

import static com.google.common.base.Preconditions.*;

public class Person {

    private String title;
    private final String name;
    private final String surname;
    private String prefix;

    private Person(String title, String name, String surname, String prefix) {
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.prefix = prefix;
    }

    public static Builder builder(String name, String surname) {
        return new Builder(name, surname);
    }

    public static class Builder {

        private String title;
        private final String name;
        private final String surname;
        private String prefix;

        private Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder prefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        public Person build() {
            checkState(null != prefix); // IllegalStateException
            return new Person(title, name, surname, prefix);
        }
    }

    public static void main(String[] args) {
        Person person = Person.builder("Juan Pablo", "Ospina Herrera")
                .prefix("Mr")
                .build();
        System.out.println(person);
    }
}
