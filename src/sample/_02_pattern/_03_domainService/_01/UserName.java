package sample._02_pattern._03_domainService._01;

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
}
