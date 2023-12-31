package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int[] secondArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(r->Integer.parseInt(r))
                .toArray();
        int sum = 0;
        boolean isEqual = true;

        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] == secondArray[i])
                sum += firstArray[i];
            else {
                isEqual = false;
                sum = i;
                break;
            }

        }
        if (isEqual)
            System.out.printf("Arrays are identical. Sum: %d", sum);
        else System.out.printf("Arrays are not identical. Found difference at %d index.", sum);

    }
}
