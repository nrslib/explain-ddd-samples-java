package sample._01_oop._6th;

public class Program {
    public static void main(String[] args) {
        var userRepository = new MockUserRepository();
        var service = new UserService(userRepository);
        service.register("naruse");
    }
}
