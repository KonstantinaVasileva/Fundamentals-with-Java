package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class StrongNumber_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int originalNum = num;
        int sumOfFactorial = 0;

        while (num != 0){
            int temporaryNum = num % 10;
            int factorial = 1;
            num = num / 10;
            for (int i = 1; i <= temporaryNum; i++) {
                factorial *= i;
            }
            sumOfFactorial +=factorial;
        }
        if (originalNum == sumOfFactorial)
            System.out.println("yes");
        else System.out.println("no");

    }
}
