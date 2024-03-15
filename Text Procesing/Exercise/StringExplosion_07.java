package TextProcessing.Exercise;

import java.util.Scanner;

public class StringExplosion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '>' && i < text.length() - 1 && Character.isDigit(text.charAt(i + 1))) {
                deleted(text, i);
            }
        }
        System.out.println(text);

    }

    public static void deleted(StringBuilder text, int i) {
        int number = Integer.parseInt(String.valueOf(text.charAt(i + 1)));
        boolean isFirstIteration = true;
        for (int j = 1; j <= number; j++) {

            int index = i + j;
            if (index >= text.length()) {
                break;
            }
            if (text.charAt(index) == '>') {
                number++;
                continue;
            }
            if (isFirstIteration) {
                isFirstIteration = false;
            } else if (Character.isDigit(text.charAt(index))) {
                number += Integer.parseInt(String.valueOf(text.charAt(index)));
            }
            text.delete(index, index + 1);
            j--;
            number--;
        }
    }
}
