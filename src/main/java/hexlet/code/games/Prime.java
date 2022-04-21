package hexlet.code.games;

import static hexlet.code.Utils.generateNumber;
import hexlet.code.Engine;

public class Prime {
    private static final int MIN = 1;
    private static final int MAX = 20;

    private static final String DESCRIPTION =
            "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i += 1) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static String[] generateRoundData() {
        int number = generateNumber(MIN, MAX);

        String question = Integer.toString(number);
        String answer = isPrime(number) ? "yes" : "no";

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
