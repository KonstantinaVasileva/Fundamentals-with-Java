package Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            boolean isMax = true;
            for (int j = i+1; j < arrayOfNumbers.length; j++) {
                if (arrayOfNumbers[i]<= arrayOfNumbers[j]){
                    isMax = false;
                    break;
                }
            }
            if (isMax)
                System.out.print(arrayOfNumbers[i] + " ");
        }
    }
}
