package MapsLambdaAndStreamAPI_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        while (scanner.hasNextLine()){
            text += scanner.nextLine() + " ";
        }
        String[] textAsList = text.trim().split(" ");
       // text.add(Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList()));

        LinkedHashMap<String, Integer> legendaryItems = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> items = new LinkedHashMap<>();

        for (int i = 0; i < textAsList.length / 2; i++) {
            int quantity = Integer.parseInt(textAsList[2 * i]);
            String material = textAsList[2 * i + 1].toLowerCase();
            if (isLegendaryItem(material)) {
                legendaryItems.putIfAbsent(material, 0);
                legendaryItems.put(material, legendaryItems.get(material) + quantity);
                if (legendaryItems.get(material) >= 250) {
                    legendaryItems.put(material, legendaryItems.get(material) - 250);
                    System.out.printf("%s obtained!\n",
                            (material.equals("shards") ? "Shadowmourne" : (material.equals("fragments") ? "Valanyr" : "Dragonwrath")));
                    break;
                }
            } else {
                items.putIfAbsent(material, 0);
                items.put(material, items.get(material) + quantity);
            }
        }

        System.out.printf("shards: %d\nfragments: %d\nmotes: %d\n",
                legendaryItems.get("shards") == null ? 0 : legendaryItems.get("shards"),
                legendaryItems.get("fragments") == null ? 0 : legendaryItems.get("fragments"),
                legendaryItems.get("motes") == null ? 0 : legendaryItems.get("motes"));

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }

    public static boolean isLegendaryItem(String material) {
        if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
            return true;
        }
        return false;
    }
}
