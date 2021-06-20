package sample._03_microservice._01.sns.application.user;

import sample._03_microservice._01.lib.infrasupport.transaction.Isolation;
import sample._03_microservice._01.lib.infrasupport.transaction.Transactional;
import sample._03_microservice._01.sns.domain.user.User;
import sample._03_microservice._01.sns.domain.user.UserName;
import sample._03_microservice._01.sns.domain.user.UserRepository;
import sample._03_microservice._01.sns.domain.user.UserService;

public class UserApplicationService {
    private final UserRepository repository;
    private final UserService userService;

    public UserApplicationService(UserRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void createUser(String username) {
        var user = new User(new UserName(username));

        if (userService.exists(user)) {
            throw new RuntimeException("ユーザが存在しています");
        }

        repository.save(user);
    }
}
