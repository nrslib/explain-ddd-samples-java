package sample._07_common_troubles._02;

import java.util.Objects;
import java.util.UUID;

public class User {
    private final UserId id;
    private UserName name;
    private boolean isPremium;

    public User(UserId id, UserName name, boolean isPremium) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);

        this.id = id;
        this.name = name;
        this.isPremium = isPremium;
    }

    public User(UserName name) {
        this(new UserId(UUID.randomUUID().toString()), name, false);
    }

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
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
