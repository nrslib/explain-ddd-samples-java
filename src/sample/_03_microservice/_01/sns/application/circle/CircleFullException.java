package sample._03_microservice._01.sns.application.circle;

import sample._03_microservice._01.sns.domain.circle.CircleId;

public class CircleFullException extends RuntimeException {
    private final CircleId id;

    public CircleFullException(CircleId id) {
        this.id = id;
    }
}
