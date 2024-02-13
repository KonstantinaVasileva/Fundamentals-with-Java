package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] commandAsArrays = (command.split(" "));
            int index = Integer.parseInt(commandAsArrays[1]);

            switch (commandAsArrays[0]) {
                case "Shoot":
                    if (index < 0 || index > targets.size()) {
                        break;
                    }
                    int power = Integer.parseInt(commandAsArrays[2]);
                    if (power >= targets.get(index)) {
                        targets.remove(index);
                    } else {
                        targets.add(index, targets.get(index) - power);
                        targets.remove(index + 1);
                    }
                    break;
                case "Add":
                    if (index < 0 || index >= targets.size()) {
                        System.out.println("Invalid placement!");
                        break;
                    }
                    int value = Integer.parseInt(commandAsArrays[2]);
                    targets.add(index, value);
                    break;
                case "Strike":
                    int radius = Integer.parseInt(commandAsArrays[2]);
                    if (index < 0 || index > targets.size() || index - radius < 0 || radius + index >= targets.size()) {
                        System.out.println("Strike missed!");
                        break;
                    }
                    for (int i = index - radius; i <= index + radius; i++) {
                        targets.remove(index - radius);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.print(targets.stream().map(String::valueOf).collect(Collectors.joining("|")));

    }
}
