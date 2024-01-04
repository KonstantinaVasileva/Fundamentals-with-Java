package Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayOfDigits = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < arrayOfDigits.length; i++) {
            for (int j = i + 1; j < arrayOfDigits.length; j++) {
                if (arrayOfDigits[i] + arrayOfDigits[j] == number)
                    System.out.println(arrayOfDigits[i] + " " + arrayOfDigits[j]);
            }
        }

    }
}
