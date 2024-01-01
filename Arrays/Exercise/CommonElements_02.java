package Arrays_Exercise;

import java.util.Scanner;

public class CommonElements_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        for (String secondArrayElements:secondArray) {
            for (String firstArrayElements:firstArray) {
                if (secondArrayElements.equals(firstArrayElements))
                    System.out.print(secondArrayElements + " ");
            }
        }

    }
}
