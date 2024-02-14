package MidExam;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeeStudentPerHour = Integer.parseInt(scanner.nextLine());
        int secondEmployeeStudentPerHour = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeStudentPerHour = Integer.parseInt(scanner.nextLine());

        int studentsCount = Integer.parseInt(scanner.nextLine());

        int studentsForHour = firstEmployeeStudentPerHour + secondEmployeeStudentPerHour + thirdEmployeeStudentPerHour;

        double hour = Math.ceil(1.0 * studentsCount / studentsForHour);
        for (int i = 3; i < hour; i += 4) {
            hour++;
        }
        System.out.printf("Time needed: %.0fh.", hour);

    }
}
