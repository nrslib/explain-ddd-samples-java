package sample._07_common_troubles._02;

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

    public boolean isFull(UserRepository userRepository) {
        var members = userRepository.find(getMembers());
        var premiumNumber = members.stream().filter(User::isPremium).count();
        var limit = premiumNumber < 10 ? 30 : 50;
        return memberSize() >= limit;
    }

    public int memberSize() {
        return members.size() + 1;
    }

    public void join(User member, UserRepository userRepository) {
        Objects.requireNonNull(member);

        if (isFull(userRepository)) {
            throw new CircleFullException(id);
        }

        members.add(member.getId());
    }
}
