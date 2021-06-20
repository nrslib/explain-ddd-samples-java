package sample._02_pattern._03_domainService._01;

public class Program {
    public static void main(String[] args) {
        var user = new User(
                new UserId("test-id"),
                new UserName("John"));
        user.exists(); // ???
    }
}
