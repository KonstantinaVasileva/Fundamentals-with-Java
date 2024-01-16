package Methods_MoreExercise;

import java.util.Scanner;

public class DataTypes_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String input = scanner.nextLine();

        output(type, input);

    }

    public static void output(String type, String input) {
        if (type.equals("int")) {
            int number = Integer.parseInt(input);
            System.out.println(number * 2);
        }
        if (type.equals("real")) {
            double number = Double.parseDouble(input);
            System.out.printf("%.2f", number * 1.5);
        }
        if (type.equals("string")) {
            System.out.println("$" + input + "$");
        }
    }
}
