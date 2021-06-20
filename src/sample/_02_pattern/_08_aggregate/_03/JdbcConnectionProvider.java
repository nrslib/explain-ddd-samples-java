package sample._02_pattern._08_aggregate._03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionProvider {
    private final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String oracleUser = "user";
    private final String oraclePassword = "pass";

    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, oracleUser, oraclePassword);
            }catch (SQLException e) {
                throw new JdbcConnectionRuntimeException(e);
            }
        }

        return connection;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new JdbcConnectionRuntimeException(e);
            }
        }
    }
}
