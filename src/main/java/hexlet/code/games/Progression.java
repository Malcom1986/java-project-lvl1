package hexlet.code.games;

import static hexlet.code.Utils.generateNumber;
import hexlet.code.Engine;

public class Progression {
    private static final int MIN = 1;
    private static final int MAX = 10;
    private static final int PROGRESSION_LENGTH = 8;

    private static final String DESCRIPTION =
            "What number is missing in this progression?";

    // В идеале прогрессия должна быть быть последовательною чисел, а не строк.
    // Но в данном случае делаем упрощение - последовательность чисел представленных строками,
    // потому как реализация значительно усложняется.
    private static String[] makeProgression(int first, int step, int length) {
        String[] progression = new String[length];

        for (int i = 0; i < length; i += 1) {
            progression[i] = Integer.toString(first + i * step);
        }

        return progression;
    }

    private static String[] generateRoundData() {
        int first = generateNumber(MIN, MAX);
        int step = generateNumber(MIN, MAX);
        int hiddenMemberIndex = generateNumber(0, PROGRESSION_LENGTH - 1);

        String[] progression = makeProgression(first, step, PROGRESSION_LENGTH);
        String answer = progression[hiddenMemberIndex];

        // Для формирования строки вопроса желательно использовать готовые и простые решения
        // вместо ручного обхода циклом
        progression[hiddenMemberIndex] = "..";
        String question = String.join(" ", progression);

        return new String[] {question, answer};
    }

    public static void runGame() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i += 1) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(DESCRIPTION, roundsData);
    }
}
