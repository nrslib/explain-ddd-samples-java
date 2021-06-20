package sample._02_pattern._06_factory._03;

import java.util.ArrayList;
import java.util.Objects;

public class Circle {
    private final CircleId id;
    private UserId owner;
    private ArrayList<UserId> members;

    public Circle(CircleId id, UserId owner) {
        this(id, owner, new ArrayList<>());
    }

    public Circle(CircleId id, UserId owner, ArrayList<UserId> members) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(owner);
        Objects.requireNonNull(members);

        this.id = id;
        this.owner = owner;
        this.members = members;
    }
}
