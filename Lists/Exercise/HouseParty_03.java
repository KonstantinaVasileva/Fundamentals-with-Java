package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HouseParty_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guest = new ArrayList<>();
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {

            String command = scanner.nextLine();
            String[] name = command.split(" ");

            if (command.contains("not")) {
                if (guest.contains(name[0])) {
                    guest.remove(name[0]);
                } else System.out.printf("%s is not in the list!\n", name[0]);

            } else if (guest.contains(name[0])) {
                System.out.printf("%s is already in the list!\n", name[0]);
            } else guest.add(name[0]);
        }

        for (String name : guest)
            System.out.println(name);

    }
}
