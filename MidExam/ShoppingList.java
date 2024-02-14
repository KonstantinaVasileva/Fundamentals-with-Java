package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList = Arrays.stream((scanner.nextLine().split("!"))).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {
            String[] modifyCommand = command.split(" ");
            switch (modifyCommand[0]) {
                case "Urgent":
                    if (!shoppingList.contains(modifyCommand[1]))
                        shoppingList.add(0, modifyCommand[1]);
                    break;
                case "Unnecessary":
                    shoppingList.remove(modifyCommand[1]);
                    break;
                case "Correct":
                    if (shoppingList.contains(modifyCommand[1])) {
                        int index = shoppingList.indexOf(modifyCommand[1]);
                        shoppingList.remove(index);
                        shoppingList.add(index, modifyCommand[2]);
                    }
                    break;
                case "Rearrange":
                    if (shoppingList.contains(modifyCommand[1])) {
                        shoppingList.remove(modifyCommand[1]);
                        shoppingList.add(modifyCommand[1]);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(", ", shoppingList));

    }
}
