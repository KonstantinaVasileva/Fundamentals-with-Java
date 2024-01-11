package Methods;

import java.util.Scanner;

public class MultiplyEvensByOdds_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(result(number));

    }

    public static Integer evenSum(int num) {
        int sum = 0;
        num = Math.abs(num);
        while (num != 0) {
            int dig = num % 10;
            num = num / 10;
            if (dig % 2 == 0) {
                sum += dig;
            }
        }
        return sum;
    }

    public static Integer oddSum(int num) {
        int sum = 0;
        num = Math.abs(num);
        while (num != 0) {
            int dig = num % 10;
            num = num / 10;
            if (dig % 2 != 0) {
                sum += dig;
            }
        }
        return sum;
    }

    public static Integer result(int num) {
        int result = evenSum(num) * oddSum(num);
        return result;
    }
}