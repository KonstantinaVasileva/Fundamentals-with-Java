package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int endWhile = Math.min(firstPlayer.size(), secondPlayer.size());

        while (endWhile != 0) {
            if (firstPlayer.get(0) > secondPlayer.get(0)) {
                firstPlayer.add(firstPlayer.get(0));
                firstPlayer.add(secondPlayer.get(0));
                secondPlayer.remove(0);
                firstPlayer.remove(0);
            } else if (firstPlayer.get(0) < secondPlayer.get(0)) {
                secondPlayer.add(secondPlayer.get(0));
                secondPlayer.add(firstPlayer.get(0));
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            } else {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }

            endWhile = Math.min(firstPlayer.size(), secondPlayer.size());
        }
        int sum = 0;
        if (!firstPlayer.isEmpty()) {
            for (int card : firstPlayer)
                sum += card;
            System.out.printf("First player wins! Sum: %d", sum);
        } else if (!secondPlayer.isEmpty()) {
            for (int card : secondPlayer)
                sum += card;
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}
