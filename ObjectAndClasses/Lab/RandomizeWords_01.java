package ObjectsAndClasses;

import java.util.*;
import java.util.stream.Collectors;

public class RandomizeWords_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random rnd = new Random();

        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> randomWords = new ArrayList<>();

        int wordsSize = words.size();
        for (int i = 0; i < wordsSize; i++) {
            int position = rnd.nextInt(words.size());
            randomWords.add(words.get(position));
            words.remove(position);
        }
        for (String word : randomWords) {
            System.out.println(word);
        }

    }
}
