package FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String foodInfo = scanner.nextLine();
        String regex = "([|#])(?<name>[A-Za-z ]+)\\1(?<date>[0-9]{2}/[0-9]{2}/[0-9]{2})\\1(?<calories>[0-9]+)\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(foodInfo);

        int totalKcal = 0;
        List<String> foods = new ArrayList<>();

        while (matcher.find()){
            totalKcal += Integer.parseInt(matcher.group("calories"));
            String data = String.format("Item: %s, Best before: %s, Nutrition: %s",
                    matcher.group("name"), matcher.group("date"), matcher.group("calories"));
            foods.add(data);
            //String[] food = {matcher.group("name"), matcher.group("date"), matcher.group("calories")};
        }
        System.out.println("You have food to last you for: " + totalKcal/2000 + " days!");
        System.out.println(String.join("\n", foods));
    }
}
