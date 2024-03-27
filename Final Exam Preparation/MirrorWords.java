package FinalExam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([@#])(?<word>[A-Za-z]{3,})\\1{2}(?<mirrorWord>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> mirrorWords = new ArrayList<>();
        int count = 0;

        while (matcher.find()) {
            count++;
            StringBuilder word = new StringBuilder(matcher.group("word"));
            if (matcher.group("mirrorWord").equals(String.valueOf(word.reverse()))) {
                mirrorWords.add(matcher.group("word") + " <=> " + matcher.group("mirrorWord"));
            }
        }
        if (count == 0) {
            System.out.println("No word pairs found!\nNo mirror words!");
        } else if (mirrorWords.isEmpty()) {
            System.out.printf("%s word pairs found!\nNo mirror words!", count);
        } else {
            System.out.printf("%s word pairs found!\nThe mirror words are:\n", count);
            for (int i = 0; i < mirrorWords.size(); i++) {
                if (i == mirrorWords.size() - 1) {
                    System.out.print(mirrorWords.get(i));
                } else {
                    System.out.print(mirrorWords.get(i) + ", ");
                }
            }
        }

    }
}
