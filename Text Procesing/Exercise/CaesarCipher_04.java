package TextProcessing.Exercise;

import java.util.Scanner;

public class CaesarCipher_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            encryptedText.append((char) (text.charAt(i) + 3));
        }
        System.out.println(encryptedText);

    }
}
