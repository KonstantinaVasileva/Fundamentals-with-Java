package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> memoryCards = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        int count = 0;

        while (!input.equals("end")) {
            int[] playerChoice = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (playerChoice[0] < 0 || playerChoice[0] >= memoryCards.size()
                    || playerChoice[1] < 0 || playerChoice[1] >= memoryCards.size()
                    || playerChoice[0] == playerChoice[1]) {
                System.out.println("Invalid input! Adding additional elements to the board");
                count++;
                memoryCards.add(memoryCards.size() / 2, "-" + count + "a");
                memoryCards.add(memoryCards.size() / 2, "-" + count + "a");
                input = scanner.nextLine();
                continue;
            }

            if (memoryCards.get(playerChoice[1]).equals(memoryCards.get(playerChoice[0]))) {
                System.out.printf("Congrats! You have found matching elements - %s!\n", memoryCards.get(playerChoice[0]));
                if (playerChoice[0] < playerChoice[1]) {
                    memoryCards.remove(playerChoice[1]);
                    memoryCards.remove(playerChoice[0]);
                } else {
                    memoryCards.remove(playerChoice[0]);
                    memoryCards.remove(playerChoice[1]);
                }
            } else
                System.out.println("Try again!");
            count++;
            if (memoryCards.isEmpty()) {
                System.out.printf("You have won in %d turns!", count);
                return;
            }
            input = scanner.nextLine();
        }

        System.out.println("Sorry you lose :(");
        for (String memoryCard : memoryCards) {
            System.out.print(memoryCard + " ");

        }

    }
}
