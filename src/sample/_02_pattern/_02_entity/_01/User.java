package sample._02_pattern._02_entity._01;

import java.util.Objects;

public class User {
    private UserName name;

    public User(UserName name) {
        this.name = name;
    }

    public void changeName(UserName name) {
        Objects.requireNonNull(name);

        this.name = name;
    }
}
