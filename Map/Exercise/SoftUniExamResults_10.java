package MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        LinkedHashMap<String, Integer> users = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> languages = new LinkedHashMap<>();

        while (!text.equals("exam finished")) {
            if (text.contains("banned")) {
                String username = text.split("-")[0];
                users.remove(username);
            } else {
                String username = text.split("-")[0];
                String language = text.split("-")[1];
                int points = Integer.parseInt(text.split("-")[2]);

                if (users.containsKey(username) && users.get(username) < points) {
                    users.put(username, points);
                } else if (!users.containsKey(username)){
                    users.put(username, points);
                }
                languages.putIfAbsent(language, 0);
                languages.put(language, languages.get(language) + 1);
            }
            text = scanner.nextLine();
        }
        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : users.entrySet()) {
            System.out.printf("%s | %s\n", entry.getKey(), entry.getValue());
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : languages.entrySet()) {
            System.out.printf("%s - %d\n", entry.getKey(), entry.getValue());
        }
    }
}
