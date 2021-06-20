package sample._02_pattern._08_aggregate._02;

public class CircleFullException extends RuntimeException {
    private final CircleId id;

    public CircleFullException(CircleId id) {
        this.id = id;
    }
}
