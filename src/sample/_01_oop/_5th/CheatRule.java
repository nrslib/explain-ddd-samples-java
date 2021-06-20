package sample._01_oop._5th;

public class CheatRule implements GameRule {
    @Override
    public int judge(int lHand, int rHand) {
        return 1;
    }
}
