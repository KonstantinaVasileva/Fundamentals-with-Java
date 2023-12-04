package BasicSyntax_ConditionalStatementsandLoops;

import java.util.Scanner;

public class SumOfOddNumbers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= num ; i++) {
            System.out.println(i*2-1);
            sum += i*2-1;
        }
        System.out.println("Sum: " + sum);

    }
}
