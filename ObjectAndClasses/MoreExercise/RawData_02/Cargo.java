package ObjectsAndClasses_MoreExercise.RawData_02;

public class Cargo {
    public int weight;
    public String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }
}
