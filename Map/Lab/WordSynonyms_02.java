package MapsLambdaAndStreamAPI_Lab;

import java.util.*;

public class WordSynonyms_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<String>> synonyms = new LinkedHashMap<>();

        for (int i = 0; i < number; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (synonyms.containsKey(word)) {
                synonyms.get(word).add(synonym);
            } else {
                synonyms.put(word, new ArrayList<>(Collections.singleton(synonym)));
            }
        }
        for (Map.Entry<String, List<String>> entry : synonyms.entrySet()) {
            System.out.println(entry.getKey() + " - " + String.join(", ", entry.getValue()));
        }
    }
}
