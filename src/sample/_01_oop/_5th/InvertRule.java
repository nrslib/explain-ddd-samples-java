package sample._01_oop._5th;

public class InvertRule implements GameRule {
    @Override
    public int judge(int lHand, int rHand) {
        if (lHand == 0) { // Goo
            if (rHand == 0) { // Goo
                return 0;
            } else if (rHand == 1) { // Choki
                return -1;
            } else { // Par
                return 1;
            }
        } else if (lHand == 1) { // Choki
            if (rHand == 0) { // Goo
                return 1;
            } else if (rHand == 1) { // Choki
                return 0;
            } else { // Par
                return -1;
            }
        } else { // Par
            if (rHand == 0) { // Goo
                return -1;
            } else if (rHand == 1) { // Choki
                return 1;
            } else { // Par
                return 0;
            }
        }
    }
}
