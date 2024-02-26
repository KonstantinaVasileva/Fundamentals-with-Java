package ObjectsAndClasses_MoreExercise.CompanyRoster_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<>();
        List<Departments> departments = new ArrayList<>();

        for (int i = 1; i <= numberOfEmployees; i++) {
            String[] employeeData = scanner.nextLine().split(" ");
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String departmentName = employeeData[3];
            String email;
            String age;
            if (employeeData.length >= 5 && employeeData[4].contains("@")) {
                email = employeeData[4];
            } else {
                email = "n/a";
            }
            if (isNumber(employeeData[employeeData.length - 1])) {
                age = employeeData[employeeData.length - 1];
            } else {
                age = "-1";
            }
            Employee employee = new Employee(name, salary, position, departmentName, email, age);
            employees.add(employee);
            double salarySum = salary;
            Departments department = new Departments(1, departmentName, salarySum, salarySum);

                boolean isContainsDepartment = false;
                for (Departments depart : departments) {
                    if (depart.getName().equals(departmentName)) {
                        depart.setCount(depart.getCount() + 1);
                        depart.setSalarySum(depart.getSalarySum() + salary);
                        depart.setAverageSalary(depart.getSalarySum() / depart.getCount());
                        isContainsDepartment = true;
                    }
                }
                if (!isContainsDepartment){
                    departments.add(department);
                }
        }
        departments.sort(Comparator.comparing(Departments::getAverageSalary));
        String bestDepartment = departments.get(departments.size() - 1).getName();
        System.out.printf("Highest Average Salary: %s\n", bestDepartment);
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        for (Employee empl : employees) {
            if (empl.getDepartment().equals(bestDepartment)) {
                System.out.printf("%s %.2f %s %s\n", empl.getName(), empl.getSalary(), empl.getEmail(), empl.getAge());
            }
        }
    }

    public static boolean isNumber(String age) {
        String numbers = "0123456789";
        for (int i = 0; i < age.length(); i++) {
            if (!numbers.contains(String.valueOf(age.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
