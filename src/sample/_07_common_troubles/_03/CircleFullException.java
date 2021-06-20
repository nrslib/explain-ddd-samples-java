package sample._07_common_troubles._03;

public class CircleFullException extends RuntimeException {
    private final CircleId id;

    public CircleFullException(CircleId id) {
        this.id = id;
    }
}
