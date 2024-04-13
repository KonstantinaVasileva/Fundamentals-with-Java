package RegularFinalExam_31_03_2024;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInput = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfInput; i++) {
            String text = scanner.nextLine();
            String regex = "^([\\$%])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<firsNum>[0-9]+)\\]\\|\\[(?<secondNum>[0-9]+)\\]\\|\\[(?<thirdNum>[0-9]+)\\]\\|$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()){
                char first = (char) Integer.parseInt(matcher.group("firsNum"));
                char second = (char) Integer.parseInt(matcher.group("secondNum"));
                char third = (char) Integer.parseInt(matcher.group("thirdNum"));
                String decryptedMessage = "" + first + second + third;
                System.out.printf("%s: %s\n", matcher.group("tag"), decryptedMessage);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
