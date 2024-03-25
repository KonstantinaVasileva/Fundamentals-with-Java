package RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePassword_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        String regex = "_\\.+(?<password>[A-Z][A-Za-z0-9]{4,}[A-Z])_\\.*";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 1; i <= count; i++) {
            String password = scanner.nextLine();
            Matcher matcher = pattern.matcher(password);
            if (matcher.find()) {
                if (group(matcher.group("password")).isEmpty()) {
                    System.out.println("Group: default");
                } else
                    System.out.println("Group: " + group(matcher.group("password")));
            } else System.out.println("Invalid pass!");
        }

    }

    public static String group(String password) {
        String group = "";
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                group += ch;
            }
        }
        return group;
    }
}
