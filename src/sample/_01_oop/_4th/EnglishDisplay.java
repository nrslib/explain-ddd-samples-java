package sample._01_oop._4th;

public class EnglishDisplay implements Display {
    @Override
    public void win() {
        System.out.println("win");
    }

    @Override
    public void draw() {
        System.out.println("draw");
    }

    @Override
    public void lose() {
        System.out.println("lose");
    }
}
