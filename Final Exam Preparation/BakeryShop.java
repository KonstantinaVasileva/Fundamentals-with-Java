package FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BakeryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> foods = new LinkedHashMap<>();
        int soldQuantity = 0;

        while (true) {
            String text = scanner.nextLine();
            if (text.equals("Complete")) {
                break;
            }
            String command = text.split(" ")[0];
            int quantity = Integer.parseInt(text.split(" ")[1]);
            String food = text.split(" ")[2];

            switch (command) {
                case "Receive":
                    if (quantity < 0) {
                        break;
                    }
                    foods.putIfAbsent(food, 0);
                    foods.put(food, foods.get(food) + quantity);
                    break;
                case "Sell":
                    if (!foods.containsKey(food)) {
                        System.out.printf("You do not have any %s.\n", food);
                        break;
                    }
                    if (quantity > foods.get(food)) {
                        System.out.printf("There aren't enough %s. You sold the last %s of them.\n", food, foods.get(food));
                        soldQuantity += foods.get(food);
                        foods.remove(food);
                        break;
                    }
                    foods.put(food, foods.get(food) - quantity);
                    System.out.printf("You sold %s %s.\n", quantity, food);
                    soldQuantity += quantity;
                    if (foods.get(food) == 0) {
                        foods.remove(food);
                    }
                    break;
            }
        }
        foods.entrySet().forEach(e-> System.out.printf("%s: %s\n", e.getKey(), e.getValue()));
        System.out.printf("All sold: %s goods\n", soldQuantity);
    }
}
