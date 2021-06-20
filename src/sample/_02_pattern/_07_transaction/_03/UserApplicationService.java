package sample._02_pattern._07_transaction._03;

public class UserApplicationService {
    private final Transaction transaction;
    private final UserFactory factory;
    private final UserRepository repository;
    private final UserService userService;

    public UserApplicationService(
            Transaction transaction,
            UserFactory factory,
            UserRepository repository,
            UserService userService) {
        this.transaction = transaction;
        this.factory = factory;
        this.repository = repository;
        this.userService = userService;
    }

    public void createUser(String name) {
        transaction.begin();
        var userName = new UserName(name);
        var user = factory.create(userName);

        if (userService.exists(user)) {
            transaction.rollback();
            throw new RuntimeException("ユーザが存在しています");
        }

        repository.save(user);
        transaction.commit();
    }
}
