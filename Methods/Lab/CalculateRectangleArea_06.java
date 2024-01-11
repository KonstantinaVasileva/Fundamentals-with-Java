package Methods;

import java.util.Scanner;

public class CalculateRectangleArea_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f",rectangleArea(a, b));

    }

    public static Double rectangleArea(double a, double b) {
        double area = a * b;
        return area;
    }
}
