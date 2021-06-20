package sample._03_microservice._01.sns.domain.user;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> find(UserId id);
    Optional<User> find(UserName name);
}
