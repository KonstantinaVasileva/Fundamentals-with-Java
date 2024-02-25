package ObjectsAndClasses_Exercises.VehicleCatalogue_05;

public class Vehicle {
    public String type;

    public String getModel() {
        return model;
    }

    public String model;

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String color;
    public int horsepower;

    public Vehicle(String type, String model, String color, int horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }
}
