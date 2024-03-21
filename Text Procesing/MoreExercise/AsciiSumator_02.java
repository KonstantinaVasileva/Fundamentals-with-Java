package TextProcessing.More_Exercise;

import java.util.Scanner;

public class AsciiSumator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);
        String text = scanner.nextLine();

        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) > firstSymbol && text.charAt(i) < secondSymbol) {
                sum += text.charAt(i);
            }
        }
        System.out.println(sum);
    }
}
