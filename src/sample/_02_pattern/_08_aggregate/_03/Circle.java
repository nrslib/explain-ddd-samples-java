package sample._02_pattern._08_aggregate._03;

import java.util.ArrayList;
import java.util.Objects;

public class Circle {
    private final CircleId id;
    private UserId owner;
    private ArrayList<User> members;

    public Circle(CircleId id, UserId owner) {
        this(id, owner, new ArrayList<>());
    }

    public Circle(CircleId id, UserId owner, ArrayList<User> members) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(owner);
        Objects.requireNonNull(members);

        this.id = id;
        this.owner = owner;
        this.members = members;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public boolean isFull() {
        return memberSize() >= 30;
    }

    public int memberSize() {
        return members.size() + 1;
    }

    public void join(User member) {
        Objects.requireNonNull(member);

        if (isFull()) {
            throw new CircleFullException(id);
        }

        members.add(member);
    }
}
