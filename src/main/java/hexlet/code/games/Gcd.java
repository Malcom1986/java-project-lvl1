package hexlet.code.games;

import static hexlet.code.Utils.generateNumber;
import hexlet.code.Engine;


public class Gcd {
    private static final int MIN = 1;
    private static final int MAX = 30;

    private static final String DESCRIPTION =
            "Find the greatest common divisor of given numbers.";

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static String[] generateRoundData() {
        int number1 = generateNumber(MIN, MAX);
        int number2 = generateNumber(MIN, MAX);

        String question = number1 + " " + number2;
        String answer = Integer.toString(gcd(number1, number2));

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
