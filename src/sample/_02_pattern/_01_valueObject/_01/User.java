package sample._02_pattern._01_valueObject._01;

public class User {
    private FullName name;

    public User(FullName name) {
        this.name = name;
    }

    public FullName getName() {
        return name;
    }
}
