package sample._03_microservice._01.sns.domain.user;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean exists(User user) {
        var optUser = repository.find(user.getName());
        return optUser.isPresent();
    }
}
