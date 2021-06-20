package sample._02_pattern._01_valueObject._07;

public class Program {
    public User CreateUser(FullName name) {
        var user = new User();
//        user.setId(name);

        return user;
    }
}
