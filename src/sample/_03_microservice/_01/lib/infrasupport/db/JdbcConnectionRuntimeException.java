package sample._03_microservice._01.lib.infrasupport.db;

public class JdbcConnectionRuntimeException extends RuntimeException {
    public JdbcConnectionRuntimeException(Exception e) {
        initCause(e);
    }
}
