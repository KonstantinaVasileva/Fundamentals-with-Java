package BasicSyntax_ConditionalStatementsandLoops;

import java.util.Scanner;

public class MultiplicationTable2_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        if (multiplier > 10)
            System.out.printf("%d X %d = %d", num, multiplier, num * multiplier);
        else {

            for (int j = multiplier; j <= 10; j++) {
                System.out.printf("%d X %d = %d\n", num, j, num * j);
            }

        }

    }
}
