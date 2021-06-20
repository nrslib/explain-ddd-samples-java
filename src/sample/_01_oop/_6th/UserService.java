package sample._01_oop._6th;

import java.util.Objects;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(String name) {
        Objects.requireNonNull(name);

        var optUser = userRepository.findByName(name);

        if (optUser.isPresent()) {
            throw new RuntimeException();
        }

        var user = new User(name);
        userRepository.save(user);
    }
}
