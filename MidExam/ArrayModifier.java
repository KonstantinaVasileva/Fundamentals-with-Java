package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String text = scanner.nextLine();

        while (!text.equals("end")){
            String[] command = text.split(" ");
            if (text.contains("swap")){
                int temp = numbers[Integer.parseInt(command[1])];
                numbers[Integer.parseInt(command[1])] = numbers[Integer.parseInt(command[2])];
                numbers[Integer.parseInt(command[2])] = temp;
            }
            if (text.contains("multiply")){
                numbers[Integer.parseInt(command[1])] = numbers[Integer.parseInt(command[1])] * numbers[Integer.parseInt(command[2])];
            }
            if (text.contains("decrease")){
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] -= 1;
                }
            }
            text = scanner.nextLine();
        }
        System.out.println(String.join(", ", Arrays.toString(numbers)).replaceAll("[]\\[]", ""));

    }
}
