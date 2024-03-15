package TextProcessing.Exercise;

import java.util.Scanner;

public class LettersChangeNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        double sum = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            double number = Double.parseDouble(word.substring(1, word.length() - 1));
            char letterBeforeNumber = word.charAt(0);
            char letterAfterNumber = word.charAt(word.length() - 1);
            int positionFirstLetter = alphabet(String.valueOf(letterBeforeNumber).toLowerCase());
            int positionLastLetter = alphabet(String.valueOf(letterAfterNumber).toLowerCase());
            if (Character.isUpperCase(letterBeforeNumber)) {
                number = number / positionFirstLetter;
            } else {
                number = number * positionFirstLetter;
            }
            if (Character.isUpperCase(letterAfterNumber)) {
                number -= positionLastLetter;
            } else {
                number += positionLastLetter;
            }
            sum += number;
        }
        System.out.printf("%.2f", sum);
    }

    public static int alphabet(String letter) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int position = alphabet.indexOf(letter) + 1;
        return position;
    }
}
