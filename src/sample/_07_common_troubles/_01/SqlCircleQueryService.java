package sample._07_common_troubles._01;

import java.sql.SQLException;
import java.util.ArrayList;

public class SqlCircleQueryService implements CircleQueryService {
    private final JdbcConnectionProvider provider;

    public SqlCircleQueryService(JdbcConnectionProvider provider) {
        this.provider = provider;
    }

    @Override
    public ArrayList<CircleSummary> GetSummaries(int page, int size) {
        try (var connection = provider.getConnection()) {
            try (var statement = connection.prepareStatement(
                    "SELECT circles.id AS circleId, circles.name AS circleName, users.name AS ownerName" +
                            " FROM circles" +
                            " LEFT OUTER JOIN users" +
                            "   ON circles.ownerId = users.id" +
                            " ORDER BY cicles.created" +
                            " OFFSET ? ROWS" +
                            " FETCH FIRST ? ROWS ONLY")) {
                statement.setInt(1, page * size);
                statement.setInt(2, size);
                var rs = statement.executeQuery();
                var summaries = new ArrayList<CircleSummary>();
                while (rs.next()) {
                    var summary = new CircleSummary(
                            rs.getString("circleId"),
                            rs.getString("circleName"),
                            rs.getString("ownerName"));
                    summaries.add(summary);
                }
                return summaries;
            }

        }catch (SQLException e) {
            throw new JdbcConnectionRuntimeException(e);
        }
    }
}
