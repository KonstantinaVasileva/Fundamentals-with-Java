package ObjectsAndClasses_MoreExercise.CarSalesman_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Engine[] engines = new Engine[n];

        for (int i = 0; i < n; i++) {
            String[] engineData = scanner.nextLine().split(" ");
            Engine engine = getEngine(engineData);
            engines[i] = engine;
        }

        int m = Integer.parseInt(scanner.nextLine());
        Car[] cars = new Car[m];

        for (int i = 0; i < m; i++) {
            String[] carData = scanner.nextLine().split(" ");
            String model = carData[0];
            String engine = carData[1];
            String weight;
            String color;
            if (carData.length >= 3 && isNumber(carData[2])) {
                weight = carData[2];
            } else weight = "n/a";
            if (carData.length >= 3 && !isNumber(carData[carData.length - 1])) {
                color = carData[carData.length - 1];
            } else color = "n/a";
            for (int j = 0; j < n; j++) {
                if (engines[j].getModel().equals(engine)) {
                    Car car = new Car(model, engines[j], weight, color);
                    cars[i] = car;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.printf("%s:\n  %s:\n    Power: %s\n    Displacement: %s\n    Efficiency: %s\n  Weight: %s\n  Color: %s\n",
                    cars[i].getModel(),
                    cars[i].getEngine().getModel(),
                    cars[i].getEngine().getPower(),
                    cars[i].getEngine().getDisplacement(),
                    cars[i].getEngine().getEfficiency(),
                    cars[i].getWeight(),
                    cars[i].getColor());
        }
    }

    private static Engine getEngine(String[] engineData) {
        String model = engineData[0];
        String power = engineData[1];
        String displacement;
        String efficiency;
        if (engineData.length >= 3 && isNumber(engineData[2])) {
            displacement = engineData[2];
        } else displacement = "n/a";
        if (!isNumber(engineData[engineData.length - 1])) {
            efficiency = engineData[engineData.length - 1];
        } else efficiency = "n/a";
        Engine engine = new Engine(model, power, displacement, efficiency);
        return engine;
    }

    public static boolean isNumber(String data) {
        for (int i = 0; i < data.length(); i++) {
            String digits = "0123456789";
            if (!digits.contains(String.valueOf(data.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
