package sample._02_pattern._06_factory._02;

public class SqlFactoryException extends RuntimeException {
    public SqlFactoryException(Exception e) {
        this.initCause(e);
    }
}
