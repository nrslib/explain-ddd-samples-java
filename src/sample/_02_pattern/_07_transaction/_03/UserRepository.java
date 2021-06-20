package sample._02_pattern._07_transaction._03;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> find(UserId id);
    Optional<User> find(UserName name);
}
