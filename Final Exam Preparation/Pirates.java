package FinalExam;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> populations = new LinkedHashMap<>();
        Map<String, Integer> golds = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Sail")) {
                break;
            }
            String city = input.split("\\|\\|")[0];
            int population = Integer.parseInt(input.split("\\|\\|")[1]);
            int gold = Integer.parseInt(input.split("\\|\\|")[2]);
            if (populations.containsKey(city)) {
                populations.put(city, populations.get(city) + population);
                golds.put(city, golds.get(city) + gold);
            } else {
                populations.put(city, population);
                golds.put(city, gold);
            }
        }

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }
            String[] command = input.split("=>");
            String town = command[1];
            switch (command[0]) {
                case "Plunder":
                    int people = Integer.parseInt(command[2]);
                    int gold = Integer.parseInt(command[3]);

                    populations.put(town, populations.get(town) - people);
                    golds.put(town, golds.get(town) - gold);

                    System.out.printf("%s plundered! %s gold stolen, %s citizens killed.\n", town, gold, people);
                    if (populations.get(town) == 0 || golds.get(town) == 0) {
                        populations.remove(town);
                        golds.remove(town);
                        System.out.printf("%s has been wiped off the map!\n", town);
                    }
                    break;
                case "Prosper":
                    int gold1 = Integer.parseInt(command[2]);
                    if (gold1 <= 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        golds.put(town, golds.get(town) + gold1);
                        System.out.printf("%s gold added to the city treasury. %s now has %s gold.\n", gold1, town, golds.get(town));
                    }
                    break;
            }
        }
        System.out.printf("Ahoy, Captain! There are %s wealthy settlements to go to:\n", populations.size());
        for (Map.Entry<String, Integer> town : populations.entrySet()) {
            System.out.printf("%s -> Population: %s citizens, Gold: %s kg\n", town.getKey(), town.getValue(), golds.get(town.getKey()));
        }
    }
}
