package sample._02_pattern._08_aggregate._03;

import java.util.Objects;

public class CircleApplicationService {
    private final CircleRepository circleRepository;
    private final UserRepository userRepository;

    public CircleApplicationService(CircleRepository circleRepository, UserRepository userRepository) {
        this.circleRepository = circleRepository;
        this.userRepository = userRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void join(CircleId circleId, UserId memberId) {
        Objects.requireNonNull(circleId);
        Objects.requireNonNull(memberId);

        var optUser = userRepository.find(memberId);
        if (optUser.isEmpty()){
            throw new IllegalArgumentException("Not found user:" + memberId.getValue());
        }

        var optCircle = circleRepository.find(circleId);
        if (optCircle.isEmpty()) {
            throw new IllegalArgumentException("Not found circle:" + circleId.getValue());
        }

        var circle = optCircle.get();

        if (circle.isFull()) {
            throw new CircleFullException(circleId);
        }

        circle.join(optUser.get());
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void changeCircleMemberName(CircleId id, UserId memberId, String name) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(memberId);

        var optCircle = circleRepository.find(id);
        if (optCircle.isEmpty()) {
            throw new IllegalArgumentException("Not found circle:" + id.getValue());
        }

        var circle = optCircle.get();
        circle.getMembers()
                .stream()
                .filter(x -> x.equals(memberId))
                .findFirst()
                .flatMap(x -> userRepository.find(x.getId()))
                .ifPresent(x -> x.changeName(new UserName(name)));
        circleRepository.save(circle);
    }
}
