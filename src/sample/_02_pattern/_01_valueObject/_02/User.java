package sample._02_pattern._01_valueObject._02;

public class User {
    private FullName name;

    public User(FullName name) {
        this.name = name;
    }

    public FullName getName() {
        return name;
    }

    public void changeLastName(String lastName) {
        this.name = new FullName(name.getFirstName(), lastName);
    }
}
