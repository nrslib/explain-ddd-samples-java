package sample._07_common_troubles._01;

public class JdbcConnectionRuntimeException extends RuntimeException {
    public JdbcConnectionRuntimeException(Exception e) {
        initCause(e);
    }
}
