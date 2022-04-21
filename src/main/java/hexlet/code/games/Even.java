package hexlet.code.games;

import static hexlet.code.Utils.generateNumber;
import hexlet.code.Engine;



public class Even {

    private static final int MIN = 1;
    private static final int MAX = 100;

    private static final String DESCRIPTION =
                "Answer 'yes' if number even otherwise answer 'no'.";


    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static String[] generateRoundData() {
        int number = generateNumber(MIN, MAX);

        String question = Integer.toString(number);
        String answer = isEven(number) ? "yes" : "no";

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
