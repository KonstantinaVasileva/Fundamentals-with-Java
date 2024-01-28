package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagon = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.contains("Add")) {
                String[] textCommand = command.split(" ");
                wagon.add(Integer.parseInt(textCommand[1]));
            } else {
                int people = Integer.parseInt(command);
                for (int i = 0; i < wagon.size(); i++) {

                    if (wagon.get(i) + people <= maxCapacity) {
                        wagon.add(i, wagon.get(i) + people);
                        wagon.remove(i + 1);
                        break;
                    }
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(Arrays.toString(wagon.toString().split(" ")).replaceAll("[\\[\\],]", ""));

    }
}
