package Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayOfInt = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int temp = 0;
        int currentCount = 1;
        int count = 1;

        for (int i = 1; i < arrayOfInt.length; i++) {

            if (arrayOfInt[i] == arrayOfInt[i - 1]) {
                count++;
            } else count = 1;

            if (count > currentCount) {
                temp = arrayOfInt[i];
                currentCount = count;
            }

        }
        for (int i = 0; i < currentCount; i++) {
            System.out.print(temp + " ");
        }

    }
}
