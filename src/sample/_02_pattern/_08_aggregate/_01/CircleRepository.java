package sample._02_pattern._08_aggregate._01;

import java.util.Optional;

public interface CircleRepository {
    void save(Circle circle);
    Optional<Circle> find(CircleId id);
}
