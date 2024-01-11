package Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int pow = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.####").format(powNum(number, pow)));

    }

    public static double powNum(double number, int pow) {
        double result = 1;
        for (int i = 1; i <= pow; i++) {
            result *= number;
        }
        return result;
    }
}
