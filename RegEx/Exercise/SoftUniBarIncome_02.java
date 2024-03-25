package RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "%(?<customer>[A-Z][a-z]+)%[^.%|$]*<(?<product>\\w+)>[^.%|$]*\\|(?<count>[0-9]+)\\|[^.%|$]*?(?<price>[0-9]+\\.?[0-9]*)\\$";
        // String regex = "%(?<customer>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.?[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);
        double totalPrice = 0;

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end of shift")) {
                break;
            }
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                double price = Integer.parseInt(matcher.group("count")) * Double.parseDouble(matcher.group("price"));
                System.out.printf("%s: %s - %.2f\n", matcher.group("customer"), matcher.group("product"), price);
                totalPrice += price;
            }
        }
        System.out.printf("Total income: %.2f", totalPrice);

    }
}
