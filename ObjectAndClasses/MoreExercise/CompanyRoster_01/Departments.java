package ObjectsAndClasses_MoreExercise.CompanyRoster_01;

public class Departments {
    public void setCount(int count) {
        this.count = count;
    }

    public int count;
    public String name;
    public double salarySum;
    public double averageSalary;

    public Departments(int count, String name, double salarySum, double averageSalary) {
        this.count = count;
        this.name = name;
        this.salarySum = salarySum;
        this.averageSalary = averageSalary;
    }

    public double getSalarySum() {
        return salarySum;
    }


    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setSalarySum(double salarySum) {
        this.salarySum = salarySum;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public double getAverageSalary() {
        return averageSalary;
    }
}
