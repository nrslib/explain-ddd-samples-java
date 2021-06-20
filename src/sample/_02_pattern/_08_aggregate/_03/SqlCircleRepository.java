package sample._02_pattern._08_aggregate._03;

import java.sql.SQLException;
import java.util.Optional;

public class SqlCircleRepository implements CircleRepository {
    private final JdbcConnectionProvider connectionProvider;

    public SqlCircleRepository(JdbcConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public void save(Circle circle) {
        try (var connection = connectionProvider.getConnection()) {
            try (var statement = connection.prepareStatement("UPDATE users SET name = ? WHERE id = ?")) {
                for (var member : circle.getMembers()) {
                    statement.setString(1, member.getId().getValue());
                    statement.setString(2, member.getName().getValue());
                    statement.executeUpdate();
                }
            }

            connection.commit();

            // Update Circle here
        } catch (SQLException e) {
            throw new SqlRepositoryException(e);
        }
    }

    @Override
    public Optional<Circle> find(CircleId id) {
        // ...
        return Optional.empty();
    }
}
