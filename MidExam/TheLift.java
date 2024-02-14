package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleInTheQueue = Integer.parseInt(scanner.nextLine());

        int[] wagons = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < wagons.length; i++) {
            int people = 4 - wagons[i];
            wagons[i] = 4;
            peopleInTheQueue -= people;
            if ((peopleInTheQueue < 0) || (peopleInTheQueue == 0 && i != wagons.length - 1)) {
                wagons[i] += peopleInTheQueue;
                System.out.println("The lift has empty spots!");
                for (int wagon : wagons) {
                    System.out.print(wagon + " ");
                }
                return;
            }
            if (peopleInTheQueue == 0 && i == wagons.length - 1) {
                for (int wagon : wagons) {
                    System.out.print(wagon + " ");
                }
                return;
            }
        }

        System.out.printf("There isn't enough space! %d people in a queue!\n", peopleInTheQueue);
        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }

    }
}
