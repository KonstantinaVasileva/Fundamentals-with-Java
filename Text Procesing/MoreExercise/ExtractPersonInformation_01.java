package TextProcessing.More_Exercise;

import java.util.Scanner;

public class ExtractPersonInformation_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String text = scanner.nextLine();
            int firstIndex = text.indexOf('@');
            int secondIndex = text.indexOf('|');
            String name = text.substring(firstIndex + 1, secondIndex);
            firstIndex = text.indexOf('#');
            secondIndex = text.indexOf('*');
            int age = Integer.parseInt(text.substring(firstIndex + 1, secondIndex));
            System.out.printf("%s is %d years old.\n", name, age);
        }

    }
}
