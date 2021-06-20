package sample._03_microservice._01.sns.inmemoryinfrastructure.user;

import sample._03_microservice._01.lib.infrasupport.inmemory.InMemoryCrudRepository;
import sample._03_microservice._01.sns.domain.user.User;
import sample._03_microservice._01.sns.domain.user.UserId;
import sample._03_microservice._01.sns.domain.user.UserName;
import sample._03_microservice._01.sns.domain.user.UserRepository;

import java.util.Optional;

public class InMemoryUserRepository
        extends InMemoryCrudRepository<UserId, User>
        implements UserRepository {
    @Override
    protected UserId getKey(User value) {
        return value.getId();
    }

    @Override
    protected User deepClone(User value) {
        return new User(value.getId(), value.getName());
    }

    @Override
    public Optional<User> find(UserName name) {
        return keyToValue.values()
                .stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .map(this::deepClone);
    }
}
