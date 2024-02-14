package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasureChest = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            if (command.contains("Loot")) {
                List<String> itemsToLoot = Arrays.stream(command.split(" ")).collect(Collectors.toList());
                for (int i = 1; i < itemsToLoot.size(); i++) {
                    if (!treasureChest.contains(itemsToLoot.get(i)))
                        treasureChest.add(0, itemsToLoot.get(i));
                }
            }
            if (command.contains("Drop")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                if (index >= 0 && index < treasureChest.size()) {
                    String currentItem = treasureChest.get(index);
                    treasureChest.remove(index);
                    treasureChest.add(currentItem);
                }
            }
            if (command.contains("Steal")) {
                int countOfStealItem = Integer.parseInt(command.split(" ")[1]);
                if (countOfStealItem > treasureChest.size())
                    countOfStealItem = treasureChest.size();
                String[] stealItems = new String[countOfStealItem];
                int idx = 0;
                int idxForRemove = treasureChest.size() - countOfStealItem;
                int numberOfItems = treasureChest.size();
                for (int i = idxForRemove; i < numberOfItems; i++) {
                    stealItems[idx] = treasureChest.get(idxForRemove);
                    treasureChest.remove(idxForRemove);
                    idx++;
                }
                System.out.print(String.join(", ", stealItems));
                System.out.println();
            }
            command = scanner.nextLine();
        }
        if (treasureChest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double averageGain = 0;
            for (int i = 0; i < treasureChest.size(); i++) {
                averageGain += treasureChest.get(i).length();
            }
            averageGain /= treasureChest.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        }
    }
}
