package sample._03_microservice._01.sns.inmemoryinfrastructure.user;

import sample._03_microservice._01.sns.domain.user.User;
import sample._03_microservice._01.sns.domain.user.UserFactory;
import sample._03_microservice._01.sns.domain.user.UserId;
import sample._03_microservice._01.sns.domain.user.UserName;

public class InMemoryUserFactory implements UserFactory {
    private int number;

    @Override
    public User create(UserName name) {
        this.number++;
        var idValue = Integer.toString(number);
        return new User(
                new UserId(idValue),
                name
        );
    }
}
