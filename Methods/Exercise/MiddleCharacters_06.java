package Methods_Exercise;

import java.util.Scanner;

public class MiddleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(middleChar(input));

    }

    public static String middleChar(String input) {
        int index = input.length() / 2;
        String result = "";
        if (input.length() % 2 == 0) {
            result += input.charAt(index - 1);
            result += input.charAt(index);
        } else result += input.charAt(index);

        return result;
    }
}
