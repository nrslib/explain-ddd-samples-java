package sample._01_oop._4th;

public class JapaneseDisplay implements Display {
    @Override
    public void win() {
        System.out.println("勝ち");
    }

    @Override
    public void draw() {
        System.out.println("引き分け");
    }

    @Override
    public void lose() {
        System.out.println("負け");
    }
}
