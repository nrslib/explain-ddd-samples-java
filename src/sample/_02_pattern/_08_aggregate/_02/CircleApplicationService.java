package sample._02_pattern._08_aggregate._02;

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
}
