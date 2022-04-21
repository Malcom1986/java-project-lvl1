package hexlet.code;
import java.util.Scanner;

public class Engine {

    public static final int ROUNDS_COUNT = 3;

    public static void run(String description, String[][] roundsData) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(description);

        for (String[] roundData : roundsData) {
            String question = roundData[0];
            String answer = roundData[1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (!userAnswer.equals(answer)) {
                System.out.println(
                        "'" + userAnswer + "' is wrong answer ;(. "
                                + "Correct answer was '" + answer + "'."
                );
                System.out.println("Let's try again, " + userName + "!");
                scanner.close();
                return;
            }

            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + userName + "!");

        scanner.close();
    }
}
