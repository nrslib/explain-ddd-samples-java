package sample._01_oop._6th;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByName(String name);
    void save(User user);
}
