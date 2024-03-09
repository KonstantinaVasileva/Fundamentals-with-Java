package MapsLambdaAndStreamAPI.MoreExercise;

import java.util.*;

public class DragonArmy_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> dragons = new LinkedHashMap<>();
        Map<String, List<Integer>> damages = new LinkedHashMap<>();
        Map<String, List<Integer>> healths = new LinkedHashMap<>();
        Map<String, List<Integer>> armors = new LinkedHashMap<>();

        for (int i = 1; i <= count; i++) {
            String text = scanner.nextLine();

            String type = text.split(" ")[0];
            String name = text.split(" ")[1];

            int damage = text.split(" ")[2].equals("null") ? 45 : Integer.parseInt(text.split(" ")[2]);
            int health = text.split(" ")[3].equals("null") ? 250 : Integer.parseInt(text.split(" ")[3]);
            int armor = text.split(" ")[4].equals("null") ? 10 : Integer.parseInt(text.split(" ")[4]);

            String typeName = type + " " + name;
            List<Integer> damHeaArm = new ArrayList<>();

            damHeaArm.add(damage);
            damHeaArm.add(health);
            damHeaArm.add(armor);

            if (dragons.containsKey(typeName)) {

                damages.get(type).set(damages.get(type).indexOf(dragons.get(typeName).get(0)), damage);
                healths.get(type).set(healths.get(type).indexOf(dragons.get(typeName).get(1)), health);
                armors.get(type).set(armors.get(type).indexOf(dragons.get(typeName).get(2)), armor);
                dragons.put(typeName, damHeaArm);
            } else {
                damages.putIfAbsent(type, new ArrayList<>());
                healths.putIfAbsent(type, new ArrayList<>());
                armors.putIfAbsent(type, new ArrayList<>());

                damages.get(type).add(damage);
                healths.get(type).add(health);
                armors.get(type).add(armor);

                dragons.put(typeName, damHeaArm);
            }
        }
        Map<String, List<String>> typeName = new LinkedHashMap<>();

        for (Map.Entry<String, List<Integer>> entry : dragons.entrySet()) {
            String key = entry.getKey().split(" ")[0];
            String value = entry.getKey().split(" ")[1];

            typeName.putIfAbsent(key, new ArrayList<>());
            typeName.get(key).add(value);
        }

        double avrDamage;
        double avrHealth;
        double avrArmors;

        //"{Type}::({damage}/{health}/{armor})"
        //"-{Name} -> damage: {damage}, health: {health}, armor: {armor}"
        for (Map.Entry<String, List<String>> entry : typeName.entrySet()) {
            avrHealth = average(healths.get(entry.getKey()));
            avrDamage = average(damages.get(entry.getKey()));
            avrArmors = average(armors.get(entry.getKey()));

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", entry.getKey(), avrDamage, avrHealth, avrArmors);
            Collections.sort(entry.getValue());
            print(entry.getValue(), dragons, entry.getKey());
        }


    }

    public static double average(List<Integer> value) {
        int sum = 0;
        for (int i = 0; i < value.size(); i++) {
            sum += value.get(i);
        }
        return sum * 1.0 / value.size();
    }

    public static void print(List<String> key, Map<String, List<Integer>> value, String color) {
        for (String name : key) {
            String colorName = color + " " + name;
            if (value.containsKey(colorName)) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                        name,
                        value.get(colorName).get(0),
                        value.get(colorName).get(1),
                        value.get(colorName).get(2));
            }
        }
    }
}
// 90/100