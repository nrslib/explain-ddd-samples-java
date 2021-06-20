package sample._02_pattern._01_valueObject._09;

import java.util.Objects;

public class User {
    private String name;

    public User(String name) {
        Objects.requireNonNull(name);

        if (name.length() < 3) {
            throw new IllegalArgumentException("ユーザ名は3文字以上です。");
        }

        this.name = name;
    }
}
