package sample._02_pattern._01_valueObject._03;

public class Program {
    public static void main(String[] args) {
        {
            var johnAge = 25;
            var dickAge = 25;

            if (johnAge == dickAge) {
                System.out.println("same");
            } else {
                System.out.println("different");
            }
        }
        {
            var johnAge = new Age(25);
            var dickAge = new Age(25);

            if (johnAge.equals(dickAge)) {
                System.out.println("same");
            } else {
                System.out.println("different");
            }
        }
    }
}
