package com.effective.java.yanaga.effectivejava;

import java.io.Serializable;
import java.util.Optional;

public class Customer implements Serializable {

    /**
     * Optional have the disadvantage that cannot be serializable, and its better use native object and return its optional.ofnullable
     */
    private String title;

    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }
}
