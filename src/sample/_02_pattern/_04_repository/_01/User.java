package sample._02_pattern._04_repository._01;

import java.util.Objects;
import java.util.UUID;

public class User {
    private final UserId id;
    private UserName name;

    public User(UserId id, UserName name) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);

        this.id = id;
        this.name = name;
    }

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    public User(UserName name) {
        this(new UserId(UUID.randomUUID().toString()), name);
    }
}
