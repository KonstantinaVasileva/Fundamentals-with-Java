package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students2_06 {

    public static class Student {
        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        String firstName;
        String lastName;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        int age;

        public String getHometown() {
            return hometown;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        String hometown;

        public Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] dataStudents = command.split(" ");
            String firstName = dataStudents[0];
            String lastName = dataStudents[1];
            int age = Integer.parseInt(dataStudents[2]);
            String hometown = dataStudents[3];

            Student student = isStudentExisting(students, firstName, lastName);

            if (student != null) {
                student.setAge(age);
                student.setHometown(hometown);
            } else {

                students.add(new Student(firstName, lastName, age, hometown));
            }
            command = scanner.nextLine();
        }
        String city = scanner.nextLine();

        for (Student student : students) {
            if (student.getHometown().equals(city)) {
                System.out.printf("%s %s is %d years old\n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    public static Student isStudentExisting(List<Student> students, String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }
}
