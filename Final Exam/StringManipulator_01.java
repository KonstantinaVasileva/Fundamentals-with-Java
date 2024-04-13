package RegularFinalExam_31_03_2024;

import java.util.Scanner;

public class StringManipulator_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("End")) {
                break;
            }

            switch (input[0]) {
                case "Translate":
                    while (text.indexOf(input[1]) != -1) {
                        text.replace(text.indexOf(input[1]), text.indexOf(input[1]) + 1, input[2]);
                    }
                    System.out.println(text);
                    break;
                case "Includes":
                    if (text.indexOf(input[1]) != -1) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    if (text.indexOf(input[1]) == 0) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    text = new StringBuilder(text.toString().toLowerCase());
                    System.out.println(text);
                    break;
                case "FindIndex":
                    int index = text.lastIndexOf(input[1]);
                    System.out.println(index);
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(input[1]);
                    int endIndex = Integer.parseInt(input[2]);
                    text.delete(startIndex, startIndex + endIndex);
                    System.out.println(text);
                    break;
            }
        }
    }
}
