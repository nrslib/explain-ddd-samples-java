package sample._02_pattern._08_aggregate._03;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(value, userName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
