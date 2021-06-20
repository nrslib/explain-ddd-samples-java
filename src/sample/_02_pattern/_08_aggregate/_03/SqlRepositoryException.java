package sample._02_pattern._08_aggregate._03;

public class SqlRepositoryException extends RuntimeException {
    public SqlRepositoryException(Exception e) {
        this.initCause(e);
    }
}
