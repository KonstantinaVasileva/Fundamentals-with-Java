package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class DataTypeFinder_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean isString = false;
        boolean isFloating = false;

        while (!input.equals("END")) {
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false"))
                System.out.printf("%s is boolean type\n", input);
            else if (input.length() == 1) {
                if ((input.charAt(0) < 48 || input.charAt(0) > 57)) {
                    System.out.printf("%s is character type\n", input);
                } else System.out.printf("%s is integer type\n", input);
            } else {
                int numberOfSymbol = input.length();
                for (int i = 0; i < numberOfSymbol; i++) {
                    if (input.charAt(i) < 45 || input.charAt(i) == 47 || input.charAt(i) > 57){
                        isString = true;
                    } else if (input.charAt(i) == 46)
                        isFloating = true;
                }
                if (isString)
                    System.out.printf("%s is string type\n", input);
                else if (isFloating) {
                    System.out.printf("%s is floating point type\n", input);
                } else System.out.printf("%s is integer type\n", input);
            }
            input = scanner.nextLine();
            isString = false;
            isFloating = false;
        }

    }
}
