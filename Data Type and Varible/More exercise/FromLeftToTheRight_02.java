package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class FromLeftToTheRight_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        long numberOne = 0;
        long numberTwo = 0;

        for (int i = 0; i < num; i++) {
            String twoNumbers = scanner.nextLine();
            int j;
            for (j = 0; j < twoNumbers.length(); j++) {
                if (twoNumbers.charAt(j) == ' ') {
                    break;
                }
            }
            numberOne = Long.parseLong(twoNumbers.substring(0, j ));
            numberTwo = Long.parseLong(twoNumbers.substring(j + 1));

            long maxNumber = Math.max(numberOne, numberTwo);
            int sumOfDigit = 0;
            while (maxNumber != 0) {
                long tempNum = maxNumber % 10;
                maxNumber = maxNumber / 10;
                sumOfDigit += tempNum;
            }
            System.out.println(Math.abs(sumOfDigit));

        }
    }
}
