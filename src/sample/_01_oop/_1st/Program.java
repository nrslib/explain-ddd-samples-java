package sample._01_oop._1st;

public class Program {
    public static void main(String[] args) {
        var result = judge(1, 0);
        evaluate(result);
    }

    private static int judge(int lHand, int rHand) {
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

    private static void evaluate(int result) {
        if (result == 1) {
            System.out.println("勝ち");
        } else if (result == 0) {
            System.out.println("引き分け");
        } else {
            System.out.println("負け");
        }
    }
}
