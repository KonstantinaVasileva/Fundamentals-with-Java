package MidExam;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rooms = scanner.nextLine().split("\\|");
        int health = 100;
        int bitcoin = 0;

        for (int room = 0; room < rooms.length; room++) {
            String[] command = rooms[room].split(" ");
            int amount = Integer.parseInt(command[1]);
            if (rooms[room].contains("potion")) {

                health += amount;
                if (health > 100) {
                    amount -= health - 100;
                    health = 100;
                }
                System.out.printf("You healed for %d hp.\nCurrent health: %d hp.\n", amount, health);
            } else if (rooms[room].contains("chest")) {
                bitcoin += amount;
                System.out.printf("You found %d bitcoins.\n", amount);
            } else {
                health -= amount;
                if (health > 0) {
                    System.out.printf("You slayed %s.\n", command[0]);
                } else {
                    System.out.printf("You died! Killed by %s.\nBest room: %d", command[0], room + 1);
                    return;
                }
            }

        }
        System.out.printf("You've made it!\n" +
                "Bitcoins: %d\n" +
                "Health: %d\n", bitcoin, health);

    }
}
