package sample._07_common_troubles._03;

public class CircleMemberFullSpecification {
    private final UserRepository userRepository;

    public CircleMemberFullSpecification(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isSatisfiedBy(Circle circle) {
        var members = userRepository.find(circle.getMembers());
        var premiumNumber = members.stream().filter(User::isPremium).count();
        var limit = premiumNumber < 10 ? 30 : 50;
        return circle.memberSize() >= limit;
    }
}
