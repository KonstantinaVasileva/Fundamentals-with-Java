package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int bombNumber = Integer.parseInt(scanner.next());
        int power = Integer.parseInt(scanner.next());

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bombNumber) {
                if (i + power < numbers.size()) {
                    for (int j = 0; j <= power; j++) {
                        numbers.remove(i);
                    }
                } else {
                    while (numbers.size() > i) {
                        numbers.remove(i);
                    }
                }
                if (i - power < 0)
                    for (int j = 0; j < i; j++) {
                        numbers.remove(0);
                    }
                else {
                    for (int j = 0; j < power; j++)
                        numbers.remove(i - power);

                }
                i = 0;
            }
        }
        int sum = 0;
        for (int num : numbers)
            sum += num;
        System.out.print(sum);

    }
}
