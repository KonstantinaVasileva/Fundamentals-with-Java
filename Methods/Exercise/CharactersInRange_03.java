package Methods_Exercise;

import java.util.Scanner;

public class CharactersInRange_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char startChar = scanner.nextLine().charAt(0);
        char finalChar = scanner.nextLine().charAt(0);

        System.out.println(rowOfChar(startChar, finalChar));

    }

    public static String rowOfChar(char start, char end) {
        String row = "";
        if (start < end) {
            char newStart = (char) (start + 1);
            for (char i = newStart; i < end; i++) {
                row = row + i + " ";
            }
        } else {
            char newStart = (char) (end + 1);
            for (char i = newStart; i < start; i++) {
                row = row + i + " ";
            }
        }
        return row;
    }
}
