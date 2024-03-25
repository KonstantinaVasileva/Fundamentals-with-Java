package RegularExpressions.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String healthRegex = "[^0-9+*/.-]";
        String damageRegex = "(?<number>-?[0-9]+\\.?[0-9]*)";
        Pattern patternHealth = Pattern.compile(healthRegex);
        Pattern patternDamage = Pattern.compile(damageRegex);
        List<String> demons = Arrays.stream(scanner.nextLine().trim().split("\\s*,\\s*")).collect(Collectors.toList());

        for (String demon : demons) {
            int health = 0;
            double damage = 0;
            Matcher matcherHealth = patternHealth.matcher(demon);
            Matcher matcherDamage = patternDamage.matcher(demon);
            while (matcherHealth.find()) {
                for (char ch : matcherHealth.group().toCharArray()) {
                    health += ch;
                }
            }
            while (matcherDamage.find()) {
                damage += Double.parseDouble(matcherDamage.group("number"));
            }
            for (char ch : demon.toCharArray()) {
                if (ch == '*') damage = damage * 2;
                else if (ch == '/') damage = damage / 2;
            }
            System.out.printf("%s - %d health, %.2f damage\n", demon, health, damage);
        }

    }
}
