package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String text = scanner.nextLine();

        while (!text.equals("End")) {
            String[] command = text.split(" ");
            switch (command[0]) {
                case "Add":
                    numbers.add(Integer.valueOf(command[1]));
                    break;
                case "Insert":
                    if (isValid(Integer.parseInt(command[2]), numbers))
                        numbers.add(Integer.parseInt(command[2]), Integer.valueOf(command[1]));
                   else System.out.println("Invalid index");
                    break;
                case "Remove":
                    if (isValid(Integer.parseInt(command[1]), numbers))
                        numbers.remove(Integer.parseInt(command[1]));
                    else System.out.println("Invalid index");
                    break;
                case "Shift":
                    if (command[1].equals("left")) {
                        for (int i = 0; i < Integer.parseInt(command[2]); i++) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        }
                    }
                    if (command[1].equals("right")) {
                        for (int i = 0; i < Integer.parseInt(command[2]); i++) {
                            numbers.add(0,numbers.get(numbers.size() - 1));
                            numbers.remove(numbers.size() - 1);
                        }
                    }

            }
            text = scanner.nextLine();
        }
        System.out.println(Arrays.toString(numbers.toString().split(" ")).replaceAll("[\\[\\],]", ""));

    }

    public static boolean isValid(int idx, List<Integer> num) {
        return idx < num.size() && idx >= 0;
    }

}
