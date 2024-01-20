package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SpiceMustFlow_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int allSpice = 0;
        int count = 0;

        while (startingYield >= 100){
            allSpice += startingYield - 26;
            startingYield -= 10;
            count ++;
        }
        System.out.println(count);
        if (allSpice>=26)
            allSpice -= 26;
        System.out.println(allSpice);
    }
}
