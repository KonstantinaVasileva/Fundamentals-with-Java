package RegularExpressions.MoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            StringBuilder message = new StringBuilder();
            for (char ch : input.toCharArray()) {
                ch = (char) (ch - key);
                message.append(ch);
            }
            String regex = "@(?<name>[a-zA-Z]+)[^@\\-!:>]+!G!";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()){
                System.out.println(matcher.group("name"));
            }
        }
    }
}
