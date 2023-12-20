package Arrays;

import java.util.Scanner;

public class DayOfWeek_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int number = Integer.parseInt(scanner.nextLine());

        if (number >= 1 && number <= 7) {
            for (int i = 1; i <= 7; i++) {
                if (i == number)
                    System.out.println(daysOfWeek[i - 1]);
            }

        } else System.out.println("Invalid day!");
    }
}
