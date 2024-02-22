package ObjectsAndClasses_Exercises.Students_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        List <Students> students = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            String[] studentData = scanner.nextLine().split(" ");
            String firstName = studentData[0];
            String lastName = studentData[1];
            double grade = Double.parseDouble(studentData[2]);
            Students student = new Students(firstName, lastName, grade);
            students.add(student);
        }
        students.sort(Comparator.comparing(Students::getGrade).reversed());

        for (Students st:students) {
            System.out.printf("%s %s: %.2f\n", st.getFirstName(), st.getSecondName(), st.getGrade());
        }
    }
}
