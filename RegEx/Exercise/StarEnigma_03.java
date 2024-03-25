package RegularExpressions.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfMessage = Integer.parseInt(scanner.nextLine());
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        for (int i = 1; i <= numOfMessage; i++) {
            String message = scanner.nextLine();
            int countLetter = 0;
            for (char letter : message.toCharArray()) {
                if (isSTAR(letter)) {
                    countLetter++;
                }
            }
            StringBuilder encryptedMessage = new StringBuilder();
            for (char letter : message.toCharArray()) {
                letter = (char) (letter - countLetter);
                encryptedMessage.append(letter);
            }
            String regex = "@(?<name>[A-Za-z]+)[^@,\\-!:>]*?(?<population>:[0-9]+)[^@,\\-!:>]*?!(?<attack>[A|D])![^@,\\-!:>]*?->(?<count>[0-9]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(encryptedMessage);
            if (matcher.find()) {
                if (matcher.group("attack").equals("A")) {
                    attacked.add(matcher.group("name"));
                } else {
                    destroyed.add(matcher.group("name"));
                }
            }
        }
        Collections.sort(attacked);
        Collections.sort(destroyed);
        System.out.printf("Attacked planets: %s\n", attacked.size());
        attacked.forEach(planet -> System.out.println("-> " + planet));
      //  if (attacked.size() > 0) {
      //      System.out.printf("-> %s\n", String.join("\n->", attacked));
      //  }
        System.out.printf("Destroyed planets: %s\n", destroyed.size());
        destroyed.forEach(planet -> System.out.println("-> " + planet));
       //if (destroyed.size() > 0) {
       //    System.out.printf("-> %s\n", String.join("\n-> ", destroyed));
       //}
    }

    public static boolean isSTAR(char letter) {
        String symbols = "starSTAR";
        if (symbols.indexOf(letter) == -1) {
            return false;
        }
        return true;
    }
}
