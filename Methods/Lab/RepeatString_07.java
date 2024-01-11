package Methods;

import java.util.Scanner;

public class RepeatString_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int repeatIndex = Integer.parseInt(scanner.nextLine());

        System.out.println(newString(input, repeatIndex));

    }

    public static String newString(String input, int index) {
        String repeatedString = "";
        for (int i = 0; i < index; i++) {
            repeatedString += input;
        }
        return repeatedString;
    }
}
