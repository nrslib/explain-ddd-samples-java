package sample._02_pattern._01_valueObject._02;

public class Program {
    public static void main(String[] args) {
        var user = new User(new FullName("John", "Smith"));
        user.changeLastName("田中");
    }
}
