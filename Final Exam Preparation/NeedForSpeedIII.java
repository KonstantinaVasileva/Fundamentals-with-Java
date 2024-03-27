package FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> carsMile = new LinkedHashMap<>();
        Map<String, Integer> carsFlue = new LinkedHashMap<>();

        for (int i = 1; i <= number; i++) {
            String[] carData = scanner.nextLine().split("\\|");
            carsMile.put(carData[0], Integer.parseInt(carData[1]));
            carsFlue.put(carData[0], Integer.parseInt(carData[2]));
        }
        while (true) {
            String[] command = scanner.nextLine().split(" : ");
            if (command[0].equals("Stop")) {
                break;
            }
            String car = command[1];
            switch (command[0]) {
                case "Drive":
                    int distance = Integer.parseInt(command[2]);
                    int fuel = Integer.parseInt(command[3]);
                    if (carsFlue.get(car) < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carsFlue.put(car, carsFlue.get(car) - fuel);
                        carsMile.put(car, carsMile.get(car) + distance);
                        System.out.printf("%s driven for %s kilometers. %s liters of fuel consumed.\n", car, distance, fuel);
                        if (carsMile.get(car) >= 100_000) {
                            carsMile.remove(car);
                            carsFlue.remove(car);
                            System.out.printf("Time to sell the %s!\n", car);
                        }
                    }
                    break;
                case "Refuel":
                    int fuelForFill = Integer.parseInt(command[2]);
                    int fuelInCar = carsFlue.get(car);
                    if (fuelInCar + fuelForFill > 75) {
                        carsFlue.put(car, 75);
                    } else {
                        carsFlue.put(car, fuelInCar + fuelForFill);
                    }
                    System.out.printf("%s refueled with %d liters\n", car, carsFlue.get(car) - fuelInCar);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(command[2]);
                    carsMile.put(car, carsMile.get(car) - kilometers);
                    if (carsMile.get(car) < 10_000){
                        carsMile.put(car, 10_000);
                    } else {
                        System.out.printf("%s mileage decreased by %s kilometers\n", car, kilometers);
                    }
                    break;
            }
        }
        //"{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt."
        carsMile.entrySet().forEach(entry->
                    System.out.printf("%s -> Mileage: %s kms, Fuel in the tank: %s lt.\n",
                            entry.getKey(), entry.getValue(), carsFlue.get(entry.getKey())));


    }
}
