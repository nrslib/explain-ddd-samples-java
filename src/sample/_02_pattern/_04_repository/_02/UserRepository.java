package sample._02_pattern._04_repository._02;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> find(UserId id);
    Optional<User> find(UserName name);
}
