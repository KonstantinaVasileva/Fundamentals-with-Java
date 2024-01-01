package Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int[] firstRow = new int[number];
        int[] secondRow = new int[number];

        for (int i = 1; i <= number; i++) {
            int[] twoInteger = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
            if (i % 2 == 1) {
                firstRow[i - 1] = twoInteger[0];
                secondRow[i - 1] = twoInteger[1];
            } else {
                firstRow[i - 1] = twoInteger[1];
                secondRow[i - 1] = twoInteger[0];
            }
        }
        for (int num : firstRow) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : secondRow) {
            System.out.print(num + " ");
        }

    }
}
