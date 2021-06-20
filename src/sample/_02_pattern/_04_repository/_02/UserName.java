package sample._02_pattern._04_repository._02;

import java.util.Objects;

public class UserName {
    private final String value;

    public UserName(String value) {
        Objects.requireNonNull(value);

        if (value.length() < 3) {
            throw new IllegalArgumentException("ユーザ名は3文字以上です。");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
