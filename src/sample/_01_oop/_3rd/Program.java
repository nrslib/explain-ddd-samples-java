package sample._01_oop._3rd;

public class Program {
    public static void main(String[] args) {
        var japaneseDisplay = new JapaneseDisplay();
        var gameJp = new JankenGame(japaneseDisplay);
        gameJp.play(1, 0);

        var englishDisplay = new EnglishDisplay();
        var gameEn = new JankenGame(englishDisplay);
        gameEn.play(1, 0);
    }
}
