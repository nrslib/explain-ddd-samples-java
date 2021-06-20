package sample._02_pattern._04_repository._03;

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
