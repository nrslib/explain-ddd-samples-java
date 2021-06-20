package sample._02_pattern._08_aggregate._02;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> find(UserId id);
}
