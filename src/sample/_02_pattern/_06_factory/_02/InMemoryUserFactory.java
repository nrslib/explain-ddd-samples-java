package sample._02_pattern._06_factory._02;

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
