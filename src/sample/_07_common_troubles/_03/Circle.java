package sample._07_common_troubles._03;

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

    public ArrayList<UserId> getMembers() {
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

        members.add(member.getId());
    }
}
