package Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        int[] wagons = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < wagons.length; i++) {
            int freeSpace = 4 - wagons[i];
            if (people >= freeSpace) {
                people = people - freeSpace;
                wagons[i] += freeSpace;
            } else {
                wagons[i] += people;
                people = 0;

            }
        }
        if (people > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", people);
        } else if (Arrays.stream(wagons).sum() < wagons.length * 4) {
            System.out.println("The lift has empty spots!");
        }
        for (int num:wagons) {
            System.out.print(num + " ");
        }
    }
}
