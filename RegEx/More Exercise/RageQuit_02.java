package RegularExpressions.MoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "[^0-9]+[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder output = new StringBuilder();
        StringBuilder statistic = new StringBuilder();

        while (matcher.find()) {
            String regexDigit = "[0-9]+";
            Pattern pattern1 = Pattern.compile(regexDigit);
            Matcher matcher1 = pattern1.matcher(matcher.group());
            int repeat = 0;
            if (matcher1.find()) {
                repeat = Integer.parseInt(matcher1.group());
            }
            if (repeat == 0){
                continue;
            }
            int num = String.valueOf(repeat).length();
            String text = matcher.group().substring(0, matcher.group().length() - num).toUpperCase();
            for (int i = 1; i <= repeat; i++) {
                output.append(text);
            }
            for (char ch : text.toCharArray()) {
                if (statistic.indexOf(String.valueOf(ch)) == -1) {
                    statistic.append(ch);
                }
            }
        }
        System.out.printf("Unique symbols used: %d\n", statistic.length());
        System.out.println(output);
    }
}
