package sample._03_microservice._01.sns.inmemoryinfrastructure.circle;

import sample._03_microservice._01.lib.infrasupport.inmemory.InMemoryCrudRepository;
import sample._03_microservice._01.sns.domain.circle.Circle;
import sample._03_microservice._01.sns.domain.circle.CircleId;
import sample._03_microservice._01.sns.domain.circle.CircleRepository;

import java.util.ArrayList;

public class InMemoryCircleRepository extends InMemoryCrudRepository<CircleId, Circle> implements CircleRepository {
    @Override
    protected CircleId getKey(Circle value) {
        return value.getId();
    }

    @Override
    protected Circle deepClone(Circle value) {
        return new Circle(
                value.getId(),
                value.getOwner(),
                new ArrayList<>(value.getMembers())
        );
    }
}
