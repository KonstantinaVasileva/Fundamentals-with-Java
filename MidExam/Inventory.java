package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> collectingItems = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String text = scanner.nextLine();

        while (!text.equals("Craft!")) {
            String[] command = text.split(" - ");
            switch (command[0]) {
                case "Collect":
                    if (!collectingItems.contains(command[1])) {
                        collectingItems.add(command[1]);
                    }
                    break;
                case "Drop":
                    collectingItems.remove(command[1]);
                    break;
                case "Combine Items":
                    String[] items = command[1].split(":");
                    if (collectingItems.contains(items[0])){
                        int index = collectingItems.indexOf(items[0]);
                        collectingItems.add(index + 1, items[1]);
                    }
                    break;
                case "Renew":
                    if (collectingItems.contains(command[1])){
                        collectingItems.remove(command[1]);
                        collectingItems.add(command[1]);
                    }
                    break;
            }

            text = scanner.nextLine();
        }
        System.out.println(String.join(", ", collectingItems));

    }
}
