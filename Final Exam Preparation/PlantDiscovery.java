package FinalExam;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, String> plants = new LinkedHashMap<>();
        Map<String, List<Double>> plantsRating = new LinkedHashMap<>();

        for (int i = 1; i <= number; i++) {
            String plantInfo = scanner.nextLine();
            plants.put(plantInfo.split("<->")[0], plantInfo.split("<->")[1]);
            List<Double> empty = new ArrayList<>();
            plantsRating.put(plantInfo.split("<->")[0], empty);
        }
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Exhibition")) {
                break;
            }
            String[] command = input.split(":\\s");
            switch (command[0]) {
                case "Rate":
                    String[] plantRating = command[1].split(" - ");
                    if (plantsRating.containsKey(plantRating[0])) {
                        plantsRating.get(plantRating[0]).add(Double.parseDouble(plantRating[1]));
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    String[] newRarity = command[1].split(" - ");
                    if (plants.containsKey(newRarity[0])) {
                        plants.put(newRarity[0], newRarity[1]);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    if (plants.containsKey(command[1])) {
                        List<Double> empty = new ArrayList<>();
                        plantsRating.put(command[1], empty);
                    } else {
                        System.out.println("error");
                    }
                    break;
            }
        }
        System.out.println("Plants for the exhibition:");
        plants.entrySet().forEach(entry -> {
            System.out.printf("- %s; Rarity: %s; Rating: %.2f\n",
                    entry.getKey(),
                    entry.getValue(),
                    plantsRating.get(entry.getKey()).isEmpty() ?
                            0.00 : plantsRating.get(entry.getKey()).stream().mapToDouble(Double::doubleValue).sum() / plantsRating.get(entry.getKey()).size());
        });
    }
}

