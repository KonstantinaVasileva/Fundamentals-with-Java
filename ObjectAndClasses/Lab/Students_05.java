package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students_05 {
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

        int age;

        public String getHometown() {
            return hometown;
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

        while (!command.equals("end")){
            String[] dataStudents = command.split(" ");
            String firstName = dataStudents[0];
            String lastName = dataStudents[1];
            int age = Integer.parseInt(dataStudents[2]);
            String hometown = dataStudents[3];

            Student student = new Student(firstName, lastName, age, hometown);
            students.add(student);
            command = scanner.nextLine();
        }
        String city = scanner.nextLine();

        for (Student student:students){
            if (student.getHometown().equals(city)){
                System.out.printf("%s %s is %d years old\n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }


    }
}
