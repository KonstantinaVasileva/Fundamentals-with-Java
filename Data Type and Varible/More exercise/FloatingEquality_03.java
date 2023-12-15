package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class FloatingEquality_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numberOne = Double.parseDouble(scanner.nextLine());
        double numberTwo = Double.parseDouble(scanner.nextLine());

        double difference = Math.abs(numberOne - numberTwo);

        if (difference <= 0.000001)
            System.out.println("True");
        else System.out.println("False");
    }
}
