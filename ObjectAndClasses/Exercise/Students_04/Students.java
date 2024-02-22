package ObjectsAndClasses_Exercises.Students_04;

public class Students {

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String firstName;
    public String secondName;

    public double getGrade() {
        return grade;
    }

    public double grade;

    public Students(String firstName, String secondName, double grade) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.grade = grade;
    }

}
