package sample._02_pattern._04_repository._01;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Program {
    public void createUser(String username) throws SQLException {
        var user = new User(new UserName(username));
        var userService = new UserService();
        if (userService.exists(user)) {
            throw new RuntimeException("ユーザが存在しています");
        }

        try (var connection = DriverManager
                .getConnection("jdbc:oracle:thin:@localhost:1521:XE", "user", "pass")) {
            try (var statement = connection
                    .prepareStatement("INSERT INTO users (id, name) VALUES(?, ?)")) {
                statement.setString(1, user.getId().getValue());
                statement.setString(2, user.getName().getValue());
                statement.executeUpdate();

                connection.commit();
            }
        }
    }
}
