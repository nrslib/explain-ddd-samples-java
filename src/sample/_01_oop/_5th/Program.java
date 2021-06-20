package sample._01_oop._5th;

public class Program {
    public static void main(String[] args) {
        var japaneseDisplay = new JapaneseDisplay();
        var normalRule = new NormalRule();
        var normalGame = new JankenGame(japaneseDisplay, normalRule);
        normalGame.play(1, 0);

        var invertRule = new InvertRule();
        var invertGame = new JankenGame(japaneseDisplay, invertRule);
        invertGame.play(1, 0);

        var cheatRule = new CheatRule();
        var cheatGame = new JankenGame(japaneseDisplay, cheatRule);
        cheatGame.play(1, 0);
    }
}
