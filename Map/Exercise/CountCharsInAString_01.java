package MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        LinkedHashMap<Character, Integer> count = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' '){
                continue;
            }
            count.putIfAbsent(text.charAt(i), 0);
            count.put(text.charAt(i), count.get(text.charAt(i)) + 1);
        }
        for (Map.Entry<Character, Integer> entry:count.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
