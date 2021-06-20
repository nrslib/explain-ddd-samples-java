package sample._02_pattern._02_entity._02;

public class Program {
    public static void main(String[] args){
        var userA = new User(new UserId("a"), "John");
        var userB = new User(new UserId("b"), "John");

        System.out.println(userA.equals(userB)); // false
    }
}
