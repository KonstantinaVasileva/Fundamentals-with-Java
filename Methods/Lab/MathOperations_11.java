package Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        int secondNUmber = Integer.parseInt(scanner.nextLine());
        System.out.printf(new DecimalFormat("0.##").format(calculation(firstNumber, secondNUmber, operator)));

    }


    public static double calculation(int firsNum, int secondNum, char op) {
        double result = 0;
        switch (op) {
            case '+':
                result = firsNum + secondNum;
                break;
            case '-':
                result = firsNum - secondNum;
                break;
            case '*':
                result = firsNum * secondNum;
                break;
            case '/':
                result = firsNum / secondNum;
                break;
        }
        return result;
    }
}
