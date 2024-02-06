package ListsMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> race = Arrays.stream(scanner.nextLine()
                        .split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        double leftCarTime = 0;
        double rightCarTime = 0;

        for (int i = 0; i < race.size() / 2; i++) {
            if (race.get(i) == 0) {
                leftCarTime *= 0.8;
            } else {
                leftCarTime += race.get(i);
            }
        }
        for (int i = race.size() - 1; i > race.size() / 2; i--) {
            if (race.get(i) == 0) {
                rightCarTime *= 0.8;
            } else {
                rightCarTime += race.get(i);
            }
        }
        if (leftCarTime < rightCarTime) {
            System.out.printf("The winner is left with total time: %.1f", leftCarTime);
        } else System.out.printf("The winner is right with total time: %.1f", rightCarTime);

    }
}
