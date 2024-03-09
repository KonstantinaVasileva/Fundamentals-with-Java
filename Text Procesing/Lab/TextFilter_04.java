package TextProcessing.Lab;

import java.util.Scanner;

public class TextFilter_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < banWords.length; i++) {
            while (text.contains(banWords[i])){
                StringBuilder replacement = new StringBuilder();
                for (int j = 0; j < banWords[i].length(); j++) {
                    replacement.append("*");
                }
                text = text.replace(banWords[i], replacement);
            }
        }
        System.out.println(text);
    }
}
