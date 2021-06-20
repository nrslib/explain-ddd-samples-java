package sample._02_pattern._01_valueObject._07;

public class User {
    private UserId id;
    private FullName name;

    public void setId(UserId id) {
        this.id = id;
    }

    public void setName(FullName name) {
        this.name = name;
    }
}
