package sample._01_oop._6th;

import java.util.Optional;

public class SqlUserRepository implements UserRepository {
    private final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String oracleUser = "user";
    private final String oraclePassword = "pass";

    @Override
    public Optional<User> findByName(String name) {
        var sql = "SELECT * FROM users WHERE name = ?";

        return Optional.empty();
    }

    @Override
    public void save(User user) {
        // update here
    }
}
