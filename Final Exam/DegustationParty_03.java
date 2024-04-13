package RegularFinalExam_31_03_2024;

import java.util.*;

public class DegustationParty_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> guests = new LinkedHashMap<>();
        int dislikeCount = 0;

        while (true) {
            String[] command = scanner.nextLine().split("-");
            if (command[0].equals("Stop")) {
                break;
            }
            String guest = command[1];
            String meal = command[2];
            switch (command[0]) {
                case "Like":
                    guests.putIfAbsent(guest, new ArrayList<>());
                    if (guests.get(guest).contains(meal)) {
                        break;
                    }
                    guests.get(guest).add(meal);
                    break;
                case "Dislike":
                    if (!guests.containsKey(guest)) {
                        System.out.printf("%s is not at the party.\n", guest);
                    } else if (!guests.get(guest).contains(meal)) {
                        System.out.printf("%s doesn't have the %s in his/her collection.\n", guest, meal);
                    } else {
                        guests.get(guest).remove(meal);
                        dislikeCount++;
                        System.out.printf("%s doesn't like the %s.\n", guest, meal);
                    }
                    break;

            }
        }
        guests.entrySet().forEach(e ->
                System.out.printf("%s: %s\n", e.getKey(), String.join(", ", e.getValue())));
        System.out.println("Unliked meals: " + dislikeCount);
    }
}
