package Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] wagons = new int[n];

        for (int i = 0; i < n; i++) {
            int people = Integer.parseInt(scanner.nextLine());
            wagons[i] = people;
        }
        for (int number : wagons) {
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println(Arrays.stream(wagons).sum());

    }
}
