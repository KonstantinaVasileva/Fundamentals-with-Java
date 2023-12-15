package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class BalancedBrackets_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLine = Integer.parseInt(scanner.nextLine());
        boolean isBracket = false;
        int countOpen = 0;
        int countClose = 0;

        for (int i = 1; i <= numberOfLine; i++) {
            String symbol = scanner.nextLine();

                if (symbol.equals("("))
                    countOpen++;
                if (symbol.equals(")")) {
                    countClose++;
                    if (countOpen != countClose) {
                        System.out.println("UNBALANCED");
                        return;
                    }
            }
        }
        if (countOpen == countClose)
            System.out.println("BALANCED");
        else System.out.println("UNBALANCED");


    }
}
