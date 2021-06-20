package sample._01_oop._6th;

import java.util.Optional;

public class MockUserRepository implements UserRepository {
    @Override
    public Optional<User> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {
    }
}
