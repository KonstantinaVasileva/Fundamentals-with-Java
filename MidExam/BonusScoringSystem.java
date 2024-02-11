package MidExam;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte numberOfStudents = Byte.parseByte(scanner.nextLine());
        byte lectures = Byte.parseByte(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = 0;
        byte bestStudentAttendances = 0;

        for (int i = 1; i <= numberOfStudents; i++) {
            byte attendances = Byte.parseByte(scanner.nextLine());
            double totalBonus = attendances * 1.0 / lectures * (5 + additionalBonus);
            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                bestStudentAttendances = attendances;
            }
        }
        System.out.printf("Max Bonus: %d.\nThe student has attended %d lectures.", Math.round(maxBonus), bestStudentAttendances);
    }
}
