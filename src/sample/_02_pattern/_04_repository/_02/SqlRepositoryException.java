package sample._02_pattern._04_repository._02;

public class SqlRepositoryException extends RuntimeException {
    public SqlRepositoryException(Exception e) {
        this.initCause(e);
    }
}
