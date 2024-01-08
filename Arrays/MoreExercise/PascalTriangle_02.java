package Arrays_More_Exercise;

import java.util.Scanner;

public class PascalTriangle_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int[] row = new int[number];
        row[0] = 1;
        System.out.println(1);
        for (int i = 1; i < number; i++) {

            int [] newRow = new int[i+1];
            newRow[0] = 1;
            newRow [newRow.length - 1] = 1;
            for (int j = 1; j < newRow.length-1; j++) {

                newRow[j] = row[j] + row[j-1];
            }
            for (int j = 0; j < newRow.length; j++) {
                row[j] = newRow[j];
            }
            for (int k : newRow) {
                System.out.print(k + " ");
            }
            System.out.println();
        }

    }
}
