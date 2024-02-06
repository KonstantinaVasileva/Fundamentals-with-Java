package ListsMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<String> text = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());

        String result = "";

        for (int i = 0; i < numbers.size(); i++) {
            int sumOfDigits = 0;
            int currentNum = numbers.get(i);
            while (currentNum != 0) {
                int tempDigits = currentNum % 10;
                currentNum = currentNum / 10;
                sumOfDigits += tempDigits;
            }
            int index = sumOfDigits % text.size();
            result += text.get(index);
            text.remove(index);
        }
        System.out.println(result);

    }
}
