package FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([=/])(?<name>[A-Z][A-Za-z]{2,})\\1";
        List<String> validDestination = new ArrayList<>();
        int travelPoints = 0;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            validDestination.add(matcher.group("name"));
            travelPoints += matcher.group("name").length();

        }
        System.out.println("Destinations: " + String.join(", ", validDestination));
        System.out.println("Travel Points: " + travelPoints);
    }
}
