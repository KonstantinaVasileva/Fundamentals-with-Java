package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            String barcode = scanner.nextLine();
            String regex = "([@][#]+)(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])([@][#]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(barcode);

            if (matcher.find()) {
                StringBuilder group = new StringBuilder();
                for (char ch : matcher.group("barcode").toCharArray()) {
                    if (Character.isDigit(ch)) {
                        group.append(ch);
                    }
                }
                System.out.printf("Product group: %s\n", group.length() == 0 ? "00" : group);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
