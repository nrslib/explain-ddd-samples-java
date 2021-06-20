package sample._03_microservice._01.sns.application.circle;

public class SqlRepositoryException extends RuntimeException {
    public SqlRepositoryException(Exception e) {
        this.initCause(e);
    }
}
