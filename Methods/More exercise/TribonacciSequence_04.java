package Methods_MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TribonacciSequence_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(Arrays.toString(tribonacci(number)).replaceAll("[\\[\\],]", ""));

    }

    public static int [] tribonacci(int num) {
        int[] tribonacciSequence = new int[num];
        tribonacciSequence[0] = 1;
        for (int i = 1; i < num; i++) {
            if (i == 1)
                tribonacciSequence[i] = tribonacciSequence[i - 1];
            else if (i == 2)
                tribonacciSequence[i] = tribonacciSequence[i - 1] + tribonacciSequence[i - 2];
            else
                tribonacciSequence[i] = tribonacciSequence[i - 1] + tribonacciSequence[i - 2] + tribonacciSequence[i - 3];
        }
        return tribonacciSequence;
    }
}
