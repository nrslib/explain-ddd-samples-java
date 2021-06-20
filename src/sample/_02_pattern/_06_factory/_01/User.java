package sample._02_pattern._06_factory._01;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.UUID;

public class User {
    private final UserId id;
    private UserName name;

    public User(UserId id, UserName name) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);

        this.id = id;
        this.name = name;
    }

    public User(UserName name) throws SQLException {
        Objects.requireNonNull(name);

        try (var connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "user", "pass")) {
            try (var seqNoUpdate = connection
                    .prepareStatement("UPDATE seq_numbers SET seq_no = seq_no+1 WHERE seq_key = 'users'")) {
                seqNoUpdate.executeUpdate();
            }
            try (var getCurrentSeq = connection
                    .prepareStatement("SELECT seq_no FROM seq_numbers WHERE seq_key = 'users'")) {
                var rs = getCurrentSeq.executeQuery();
                if (!rs.next()) {
                    throw new RuntimeException();
                }

                var idValue = rs.getString(1);
                this.id = new UserId(idValue);
            }
        }

        this.name = name;
    }

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }
}
