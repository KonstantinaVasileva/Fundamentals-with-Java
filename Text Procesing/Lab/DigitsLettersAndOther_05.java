package TextProcessing.Lab;

import java.util.Scanner;

public class DigitsLettersAndOther_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder ch = new StringBuilder();
        StringBuilder digit = new StringBuilder();
        StringBuilder letters = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                digit.append(text.charAt(i));
            } else if (Character.isLetter(text.charAt(i))) {
                letters.append(text.charAt(i));
            } else ch.append(text.charAt(i));
        }
        System.out.println(digit);
        System.out.println(letters);
        System.out.println(ch);

    }
}
