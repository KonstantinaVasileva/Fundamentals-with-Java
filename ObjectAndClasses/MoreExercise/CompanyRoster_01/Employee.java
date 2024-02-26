package ObjectsAndClasses_MoreExercise.CompanyRoster_01;

public class Employee {
    public String name;
    public double salary;
    public String position;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String department;
    public String email;
    public String age;


    public Employee(String name, double salary, String position, String department, String email, String age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }



}
