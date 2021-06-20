package sample._02_pattern._08_aggregate._03;

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

    public User(UserName name) {
        this(new UserId(UUID.randomUUID().toString()), name);
    }

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    public Circle createCircle() {
        return new Circle(
                new CircleId(UUID.randomUUID().toString()),
                this.id
        );
    }

    public void changeName(UserName name) {
        Objects.requireNonNull(name);

        this.name = name;
    }
}
