package sample._03_microservice._01.sns.domain.circle;

import sample._03_microservice._01.sns.domain.circle.Circle;
import sample._03_microservice._01.sns.domain.circle.CircleId;

import java.util.Optional;

public interface CircleRepository {
    void save(Circle circle);
    Optional<Circle> find(CircleId id);
}
