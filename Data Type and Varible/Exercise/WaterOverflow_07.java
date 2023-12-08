package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class WaterOverflow_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLine = Integer.parseInt(scanner.nextLine());
        int volume  = 255;

        for (int i = 0; i < numOfLine; i++) {
            int quantitiesOfWater = Integer.parseInt(scanner.nextLine());
            if (quantitiesOfWater <= volume)
                volume-=quantitiesOfWater;
            else System.out.println("Insufficient capacity!");
        }
        System.out.println(255 - volume);
    }
}
