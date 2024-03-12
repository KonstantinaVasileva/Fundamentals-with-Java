package TextProcessing.Exercise;

import java.util.Scanner;

public class CharacterMultiplier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.next();
        String secondWord = scanner.next();

        int result = 0;

        int minLength = Math.min(firstWord.length(), secondWord.length());
        for (int i = 0; i < minLength; i++) {
            result += firstWord.charAt(i) * secondWord.charAt(i);
        }
        int maxLength = Math.max(firstWord.length(), secondWord.length());
        for (int i = minLength; i < maxLength; i++) {
            if (firstWord.length() > secondWord.length())
                result += firstWord.charAt(i) ;
            else result += secondWord.charAt(i);
        }

        System.out.println(result);
    }
}
