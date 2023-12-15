package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class DecryptingMessage_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int lineOfLetters = Integer.parseInt(scanner.nextLine());
        String message = "";

        for (int i = 1; i <= lineOfLetters; i++) {
            char letter = scanner.nextLine().charAt(0);
            message += (char) (letter + key);
        }
        System.out.println(message);

    }
}
