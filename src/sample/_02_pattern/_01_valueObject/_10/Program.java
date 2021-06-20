package sample._02_pattern._01_valueObject._10;

public class Program {
    public static void main(String[] args) {
        var jpy1 = new Money(100, "JPY");
        var jpy2 = new Money(100, "JPY");
        var sum = jpy1.add(jpy2);

        var usd1 = new Money(1, "USD");
        var invalid = jpy1.add(usd1); // Error
    }
}
