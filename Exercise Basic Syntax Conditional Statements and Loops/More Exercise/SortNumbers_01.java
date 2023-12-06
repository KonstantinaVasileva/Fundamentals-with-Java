package BasicSyntaxConditionalStatementsAndLoopMoreExerrcise;

import java.util.Scanner;

public class SortNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int max;
        int min;

        max = Math.max(num1, num2);
        max = Math.max(max, num3);
        System.out.println(max);

        if (max == num1) {
            max = Math.max(num2, num3);
            min = Math.min(num2, num3); }
        else if (max == num2) {
            max = Math.max(num1, num3);
            min = Math.min(num1, num3); }
        else {
            max = Math.max(num2, num1);
            min = Math.min(num1, num2);
        }

        System.out.println(max);
        System.out.println(min);
    }
}
