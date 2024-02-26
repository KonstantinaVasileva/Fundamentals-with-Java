package ObjectsAndClasses_MoreExercise.RawData_02;

public class Car {
    public String model;
    public Engine engine;
    public Cargo cargo;
    public Tire[] tire;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire[] getTire() {
        return tire;
    }
}
