package Methods_Exercise;

import java.util.Scanner;

public class AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());

        System.out.println(subtract(number1, number2, number3));

    }

    public static Integer subtract(int num1, int num2, int num3) {
        int result = sum(num1, num2) - num3;
        return result;
    }

    public static Integer sum(int num1, int num2) {
        int result = num1 + num2;
        return result;
    }
}
