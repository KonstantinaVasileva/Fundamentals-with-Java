package Methods_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class NxNMatrix_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {

            System.out.println(Arrays.toString(matrix(number)).replaceAll("[\\[\\],]", ""));
        }
    }


    public static int[] matrix(int num) {
        int[] row = new int[num];
        Arrays.fill(row, num);
        return row;
    }
}
