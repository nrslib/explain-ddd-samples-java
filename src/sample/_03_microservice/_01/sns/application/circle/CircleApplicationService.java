package sample._03_microservice._01.sns.application.circle;

import sample._03_microservice._01.lib.infrasupport.transaction.Isolation;
import sample._03_microservice._01.lib.infrasupport.transaction.Transactional;
import sample._03_microservice._01.sns.domain.circle.CircleId;
import sample._03_microservice._01.sns.domain.circle.CircleRepository;
import sample._03_microservice._01.sns.domain.user.UserId;
import sample._03_microservice._01.sns.domain.user.UserRepository;

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
