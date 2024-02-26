package ObjectsAndClasses_MoreExercise.RawData_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split(" ");
            //"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType}
            // {Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire3Age} {Tire4Pressure} {Tire4Age}",
            // where the speed, power, weight and tire age are integers, tire pressure is a double.
            String model = carInfo[0];
            Engine engine = new Engine(Integer.parseInt(carInfo[1]), Integer.parseInt(carInfo[2]));
            Cargo cargo = new Cargo(Integer.parseInt(carInfo[3]), carInfo[4]);
            Tire[] tires = new Tire[4];
            for (int j = 0; j < 4; j++) {
                Tire tire = new Tire(Double.parseDouble(carInfo[5 + 2 * j]), Integer.parseInt(carInfo[6 + 2 * j]));
                tires[j] = tire;
            }
            Car car = new Car(model, engine, cargo, tires);
            cars[i] = car;
        }

        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
                for (int i = 0; i < n; i++) {
                    if (cars[i].getCargo().getType().equals(command)) {
                        for (int j = 0; j < 4; j++) {
                            if (cars[i].getTire()[j].getPressure() < 1) {
                                System.out.println(cars[i].getModel());
                                break;
                            }
                        }
                    }
                }
                break;
            case "flamable":
                for (int i = 0; i < n; i++) {
                    if (cars[i].getCargo().getType().equals(command) && cars[i].getEngine().getPower() > 250) {
                        System.out.println(cars[i].getModel());
                    }

                }
        }

    }

}
