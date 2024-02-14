package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        int count = 0;

        while (!command.equals("End")) {
            int index = Integer.parseInt(command);
            if (index >= 0 && index < numbers.length && numbers[index] != -1) {
                int currentNumber = numbers[index];
                numbers[index] = -1;
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] > currentNumber){
                        numbers[i] -= currentNumber;
                    } else if (numbers[i] <= currentNumber && numbers[i] != -1) {
                        numbers[i] += currentNumber;
                    }
                }
                count++;
            }

            command = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", count);
        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }
}
