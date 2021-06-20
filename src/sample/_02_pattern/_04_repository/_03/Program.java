package sample._02_pattern._04_repository._03;

public class Program {
    private final UserRepository repository;
    private final UserService userService;

    public Program(UserRepository repository, UserService userService) {
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
