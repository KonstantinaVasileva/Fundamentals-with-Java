package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class BeerKegs_08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double volume = 0;
        double maxVolume = 0;
        String maxVolumeModel = "";

        for (int i = 0; i < n; i++) {

            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            volume = Math.PI * Math.pow(radius, 2) * height;
            if (volume > maxVolume){
                maxVolume = volume;
                maxVolumeModel = model;
            }

        }
        System.out.println(maxVolumeModel);
    }

}
