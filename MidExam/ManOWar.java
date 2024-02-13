package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = Arrays.stream(scanner.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int[] warShip = Arrays.stream(scanner.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int maxHealth = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Retire")) {
            String[] attack = command.split(" ");
            switch (attack[0]) {
                case "Fire":
                    int index = Integer.parseInt(attack[1]);
                    if (isValid(index, warShip)) {
                        warShip[index] -= Integer.parseInt(attack[2]);
                        if (warShip[index] <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(attack[1]);
                    int endIndex = Integer.parseInt(attack[2]);
                    if (isValid(startIndex, pirateShip) && isValid(endIndex, pirateShip)) {
                        int damage = Integer.parseInt(attack[3]);
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip[i] -= damage;
                            if (pirateShip[i] <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int idx = Integer.parseInt(attack[1]);
                    if (isValid(idx, pirateShip)) {
                        pirateShip[idx] += Integer.parseInt(attack[2]);
                        if (pirateShip[idx] > maxHealth) {
                            pirateShip[idx] = maxHealth;
                        }
                    }
                    break;
                case "Status":
                    double minHealth = maxHealth * .2;
                    int count = 0;
                    for (int health : pirateShip) {
                        if (health < minHealth) {
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.\n", count);

            }

            command = scanner.nextLine();
        }
        System.out.printf("Pirate ship status: %d \nWarship status: %d", Arrays.stream(pirateShip).sum(), Arrays.stream(warShip).sum());

    }

    private static boolean isValid(int index, int[] warShip) {
        return index >= 0 && index < warShip.length;
    }
}
