package sample._02_pattern._04_repository._02;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class SqlUserRepository implements UserRepository {
    private final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String oracleUser = "user";
    private final String oraclePassword = "pass";

    @Override
    public void save(User user) {
        try {
            try (var connection = DriverManager.getConnection(url, oracleUser, oraclePassword)) {
                try (var statement = connection
                        .prepareStatement(" MERGE INTO users" +
                                " USING (" +
                                "   SELECT id, name FROM DUAL" +
                                " ) phantom" +
                                " ON users.id = phantom.id" +
                                " WHEN MATCHED THEN" +
                                "   UPDATE SET name = ?" +
                                " WHEN NOT MATCHED THEN" +
                                "   INSERT (id, name)" +
                                "   VALUES (?, ?)")) {
                    statement.setString(1, user.getId().getValue());
                    statement.setString(2, user.getName().getValue());
                    statement.setString(3, user.getId().getValue());
                    statement.setString(4, user.getName().getValue());
                    statement.executeUpdate();

                    connection.commit();
                }
            }
        } catch (SQLException e) {
            throw new SqlRepositoryException(e);
        }
    }

    @Override
    public Optional<User> find(UserId id) {
        try {
            try (var connection = DriverManager.getConnection(url, oracleUser, oraclePassword)) {
                try (var statement = connection
                        .prepareStatement("SELECT id, name FROM users WHERE id = ?")) {
                    statement.setString(1, id.getValue());

                    var resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        var instance = new User(
                                new UserId(resultSet.getString(1)),
                                new UserName(resultSet.getString(2))
                        );

                        return Optional.of(instance);
                    } else {
                        return Optional.empty();
                    }
                }
            }
        } catch (SQLException e) {
            throw new SqlRepositoryException(e);
        }
    }

    @Override
    public Optional<User> find(UserName name) {
        try {
            try (var connection = DriverManager.getConnection(url, oracleUser, oraclePassword)) {
                try (var statement = connection
                        .prepareStatement("SELECT id, name FROM users WHERE name = ?")) {
                    statement.setString(1, name.getValue());

                    var resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        var instance = new User(
                                new UserId(resultSet.getString(1)),
                                new UserName(resultSet.getString(2))
                        );

                        return Optional.of(instance);
                    } else {
                        return Optional.empty();
                    }
                }
            }
        } catch (SQLException e) {
            throw new SqlRepositoryException(e);
        }
    }
}
