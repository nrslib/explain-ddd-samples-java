package sample._02_pattern._07_transaction._01;

public class UserApplicationService {
    private final UserFactory factory;
    private final UserRepository repository;
    private final UserService userService;

    public UserApplicationService(
            UserFactory factory,
            UserRepository repository,
            UserService userService) {
        this.factory = factory;
        this.repository = repository;
        this.userService = userService;
    }

    public void createUser(String name) {
        var userName = new UserName(name);
        var user = factory.create(userName);

        if (userService.exists(user)) {
            throw new RuntimeException("ユーザが存在しています");
        }

        repository.save(user);
    }
}
