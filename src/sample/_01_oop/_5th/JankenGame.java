package sample._01_oop._5th;

public class JankenGame {
    private final Display display;
    private final GameRule rule;

    public JankenGame(Display display, GameRule rule) {
        this.display = display;
        this.rule = rule;
    }

    public void play(int lHand, int rHand) {
        var result = rule.judge(lHand, rHand);
        evaluate(result);
    }

    private void evaluate(int result) {
        if (result == 1) {
            display.win();
        } else if (result == 0) {
            display.draw();
        } else {
            display.lose();
        }
    }
}
