package ObjectsAndClasses_Exercises.VehicleCatalogue_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("End")) {
                break;
            }
            String type = input[0];
            String model = input[1];
            String color = input[2];
            int horsepower = Integer.parseInt(input[3]);
            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            vehicles.add(vehicle);
        }
        while (true) {
            String model = scanner.nextLine();
            if (model.equals("Close the Catalogue")) {
                break;
            }
            for (Vehicle veh : vehicles) {
                if (veh.getModel().equals(model)) {
                    System.out.printf("Type: %s\nModel: %s\nColor: %s\nHorsepower: %d\n", veh.getType().equals("car")? "Car":"Truck", veh.getModel(), veh.getColor(), veh.getHorsepower());
                }
            }
        }
        int sumCars = 0;
        int countCar = 0;
        int sumTruck = 0;
        int countTruck = 0;
        for (Vehicle veh : vehicles) {
            if (veh.getType().equals("car")) {
                sumCars += veh.getHorsepower();
                countCar++;
            } else {
                sumTruck += veh.getHorsepower();
                countTruck++;
            }
        }
        double averageHorsepowerCar = sumCars * 1.0 / countCar;
        double averageHorsepowerTruck = sumTruck * 1.0 / countTruck;
        if (countCar == 0) {
            averageHorsepowerCar = 0;
        }
        if (countTruck == 0) {
            averageHorsepowerTruck = 0;
        }
        System.out.printf("Cars have average horsepower of: %.2f.\n", averageHorsepowerCar);
        System.out.printf("Trucks have average horsepower of: %.2f.\n", averageHorsepowerTruck);

    }
}
