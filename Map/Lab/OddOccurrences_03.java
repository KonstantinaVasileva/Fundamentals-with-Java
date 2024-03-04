package MapsLambdaAndStreamAPI_Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OddOccurrences_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] word = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> e.toLowerCase())
                .toArray(String[]::new);
        LinkedHashMap<String, Integer> count = new LinkedHashMap<>();

        for (int i = 0; i < word.length; i++) {
            count.putIfAbsent(word[i], 0);
            count.put(word[i], count.get(word[i]) + 1);
        }

        String output = count.entrySet().stream()
                .filter(e -> e.getValue() % 2 == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));

        System.out.println(output);

    }
}
