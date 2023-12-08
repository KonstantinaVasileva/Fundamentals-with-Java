package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Snowballs_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        double maxValue = 0;
        int maxSnow = 0;
        int maxTime = 0;
        int maxQuality = 0;

        for (int i = 1; i <= num; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());


            double snowballValue =  Math.pow((snowballSnow / snowballTime), snowballQuality);
            if (snowballValue > maxValue) {
                maxValue = snowballValue;
                maxTime = snowballTime;
                maxSnow = snowballSnow;
                maxQuality = snowballQuality;

            }
        }
            System.out.printf("%d : %d = %.0f (%d)",
                    maxSnow, maxTime, maxValue, maxQuality);


    }
}
