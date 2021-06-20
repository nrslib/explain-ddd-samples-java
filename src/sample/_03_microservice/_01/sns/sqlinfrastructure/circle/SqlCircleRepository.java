package sample._03_microservice._01.sns.sqlinfrastructure.circle;

import sample._03_microservice._01.lib.infrasupport.db.JdbcConnectionProvider;
import sample._03_microservice._01.sns.application.circle.SqlRepositoryException;
import sample._03_microservice._01.sns.domain.circle.Circle;
import sample._03_microservice._01.sns.domain.circle.CircleId;
import sample._03_microservice._01.sns.domain.circle.CircleRepository;

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
