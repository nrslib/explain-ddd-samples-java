package sample._02_pattern._07_transaction._03;

public interface Transaction {
    void begin();
    void commit();
    void rollback();
}
