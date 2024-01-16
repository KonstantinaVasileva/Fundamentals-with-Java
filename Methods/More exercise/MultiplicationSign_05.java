package Methods_MoreExercise;

import java.util.Scanner;

public class MultiplicationSign_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        int numberThree = Integer.parseInt(scanner.nextLine());

        System.out.println(sign(numberOne, numberTwo, numberThree));
    }

    public static String sign(int num1, int num2, int num3) {
        boolean isPositive = true;
        String sign = "";

        int[] product = {num1, num2, num3};
        for (int num : product) {

            if (num == 0) {
                sign = "zero";
            }
            if (num < 0) {
                isPositive = !isPositive;

            }
        }
        if (!sign.equals("zero")) {
            if (isPositive)
                sign = "positive";
            else sign = "negative";
        }
        return sign;

    }
}
