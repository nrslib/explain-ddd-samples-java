package sample._07_common_troubles._02;

public class CircleMemberFullSpecification {
    private final UserRepository userRepository;

    public CircleMemberFullSpecification(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isSatisfiedBy(Circle circle) {
        var users = userRepository.find(circle.getMembers());
        var premiumUserNumber = users.stream().filter(x -> x.isPremium()).count();
        var limit = premiumUserNumber < 10 ? 30 : 50;
        return circle.memberSize() >= limit;
    }
}
