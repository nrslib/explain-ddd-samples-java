package sample._02_pattern._03_domainService._02;

public class Program {
    public static void main(String[] args) {
        var user = new User(
                new UserId("test-id"),
                new UserName("John"));

        var userService = new UserService();
        userService.exists(user);
    }
}
