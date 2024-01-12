package Methods_Exercise;

import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(vowels(input));

    }

    public static Integer vowels(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (isVowels(input.charAt(i)))
                count++;
        }
        return count;
    }

    public static boolean isVowels(char ch) {
        String vowels = "AOUEIaouei";
        return vowels.indexOf(ch) != -1;
    }
}
