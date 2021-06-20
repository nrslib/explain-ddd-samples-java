package sample._02_pattern._01_valueObject._01;

public class Program {
    public static void main(String[] args) {
        var user = new User(new FullName("John", "Smith"));
        user.getName().setLastName("田中");
    }
}
