package sample._02_pattern._05_applicationService._01;

public class UserApplicationService {
    private final UserRepository repository;
    private final UserService userService;

    public UserApplicationService(UserRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public void createUser(String username) {
        var user = new User(new UserName(username));

        if (userService.exists(user)) {
            throw new RuntimeException("ユーザが存在しています");
        }

        repository.save(user);
    }
}
