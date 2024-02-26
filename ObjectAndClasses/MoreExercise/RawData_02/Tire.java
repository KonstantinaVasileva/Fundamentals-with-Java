package ObjectsAndClasses_MoreExercise.RawData_02;

public class Tire {
    public int age;
    public double pressure;

    public Tire(double pressure, int age) {
        this.age = age;
        this.pressure = pressure;
    }

    public int getAge() {
        return age;
    }

    public double getPressure() {
        return pressure;
    }
}
