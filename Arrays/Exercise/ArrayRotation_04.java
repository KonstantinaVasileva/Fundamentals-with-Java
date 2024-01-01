package Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int numbers = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < numbers; i++) {
            int temporayNum = arrayOfNumbers[0];
            for (int j = 0; j < arrayOfNumbers.length - 1; j++) {

                arrayOfNumbers[j] = arrayOfNumbers[j + 1];
            }
            arrayOfNumbers[arrayOfNumbers.length - 1] = temporayNum;
        }
            for (int num : arrayOfNumbers) {
                System.out.print(num + " ");

        }
    }
}
