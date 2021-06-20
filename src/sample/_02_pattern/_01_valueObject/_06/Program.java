package sample._02_pattern._01_valueObject._06;

public class Program {
    public void main() {

    }

    private User createUser(String name) {
        var user = new User();
        user.setId(name);

        return user;
    }
}
