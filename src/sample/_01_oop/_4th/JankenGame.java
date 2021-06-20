package sample._01_oop._4th;

public class JankenGame {
    private final Display display;

    public JankenGame(Display display) {
        this.display = display;
    }

    public void play(int lHand, int rHand) {
        var result = judge(lHand, rHand);
        evaluate(result);
    }

    private int judge(int lHand, int rHand) {
        if (lHand == 0) { // Goo
            if (rHand == 0) { // Goo
                return 0;
            } else if (rHand == 1) { // Choki
                return 1;
            } else { // Par
                return -1;
            }
        } else if (lHand == 1) { // Choki
            if (rHand == 0) { // Goo
                return -1;
            } else if (rHand == 1) { // Choki
                return 0;
            } else { // Par
                return 1;
            }
        } else { // Par
            if (rHand == 0) { // Goo
                return 1;
            } else if (rHand == 1) { // Choki
                return -1;
            } else { // Par
                return 0;
            }
        }
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
