package sample._02_pattern._04_repository._02;

public class Program {
    private final UserRepository repository;

    public Program(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(String username) {
        var user = new User(new UserName(username));

        var userService = new UserService(repository);
        if (userService.exists(user)) {
            throw new RuntimeException("ユーザが存在しています");
        }

        repository.save(user);
    }
}
