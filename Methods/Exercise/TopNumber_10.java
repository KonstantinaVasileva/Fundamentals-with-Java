package Methods_Exercise;

import java.util.Scanner;

public class TopNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        specialNumber(number);

    }

    public static void specialNumber(int number) {

        for (int i = 1; i <= number; i++) {
            int sumOfDigits = 0;
            boolean oddNum = false;
            int specNum = i;
            while (specNum != 0) {
                int temp = specNum % 10;
                if (temp % 2 == 1)
                    oddNum = true;
                specNum = specNum / 10;
                sumOfDigits += temp;

            }
            if (sumOfDigits % 8 == 0 && oddNum)
                System.out.println(i);
        }
    }
}
