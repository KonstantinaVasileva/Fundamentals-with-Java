package FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> emoji = new ArrayList<>();
        String regex = "([:]{2}|[*]{2})(?<emojis>[A-Z][a-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int coolThreshold = 1;
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                coolThreshold *= Integer.parseInt(String.valueOf(ch));
            }
        }
        int count = 0;
        while (matcher.find()) {
            count++;
            int coolness = 0;
            for (char ch : matcher.group("emojis").toCharArray()) {
                coolness += ch;
            }
            if (coolness > coolThreshold) {
                emoji.add(matcher.group());
            }
        }

        System.out.printf("Cool threshold: %s\n", coolThreshold);
        System.out.printf("%s emojis found in the text. The cool ones are:\n", count);
        System.out.println(String.join("\n", emoji));
    }
}
