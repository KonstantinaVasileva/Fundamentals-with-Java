package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class PrintPartOfASCIITable_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int lastNum = Integer.parseInt(scanner.nextLine());

        for (int i = firstNum; i <= lastNum; i++) {
            char symbol = (char) i;
            System.out.print(symbol + " ");
        }

    }
}
