package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class TriplesOfLatinLetters_06 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num; i++) {
            char tempI = (char) (i + 96);
            for (int j = 1; j <= num; j++) {
                char tempJ = (char) (j + 96);
                for (int k = 1; k <= num; k++) {
                    char tempK = (char) (k + 96);
                    System.out.print(tempI);
                    System.out.print(tempJ);
                    System.out.println(tempK);
                }
            }

        }

    }
}
