package TextProcessing.More_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeTranslator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\|");

        Map<String, Character> translator = getStringCharacterMap();
        for (int i = 0; i < text.length; i++) {
            StringBuilder currentWord = new StringBuilder();
            String[] word = text[i].trim().split(" ");
            for (int j = 0; j < word.length; j++) {
                currentWord.append(translator.get(word[j]));
            }
            text[i] = currentWord.toString().toUpperCase();
        }
        System.out.println(String.join(" ", text));
    }

    private static Map<String, Character> getStringCharacterMap() {
        Map<String, Character> translator = new LinkedHashMap<>();
        char[] value = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                'y', 'z'};

        String[] key = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        for (int i = 0; i < key.length; i++) {
            translator.put(key[i], value[i]);
        }
        return translator;
    }
}
