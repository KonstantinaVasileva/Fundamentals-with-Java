package RegularExpressions.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<name>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)";
        String input = scanner.nextLine();
        double totalPrice = 0;
        List<String> validFurniture = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);


        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                validFurniture.add(matcher.group("name"));
                totalPrice += Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("quantity"));
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        validFurniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalPrice);

    }
}
