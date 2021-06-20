package sample._02_pattern._08_aggregate._03;

public class JdbcConnectionRuntimeException extends RuntimeException {
    public JdbcConnectionRuntimeException(Exception e) {
        initCause(e);
    }
}
