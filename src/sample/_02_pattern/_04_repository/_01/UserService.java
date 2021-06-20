package sample._02_pattern._04_repository._01;

import java.sql.DriverManager;
import java.sql.SQLException;

public class UserService {
    public boolean exists(User user) throws SQLException {
        try (var connection = DriverManager
                .getConnection("jdbc:oracle:thin:@localhost:1521:XE", "user", "pass")) {
            try (var statement = connection
                    .prepareStatement("SELECT id FROM users WHERE name = ?")) {
                statement.setString(1, user.getName().getValue());
                var resultSet = statement.executeQuery();

                return resultSet.next();
            }
        }
    }
}
