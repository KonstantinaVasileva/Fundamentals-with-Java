package Methods_MoreExercise;

import java.util.Scanner;

public class LongerLine_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        int x3 = Integer.parseInt(scanner.nextLine());
        int y3 = Integer.parseInt(scanner.nextLine());
        int x4 = Integer.parseInt(scanner.nextLine());
        int y4 = Integer.parseInt(scanner.nextLine());

        if (longerLine(x1, y1, x2, y2) >= longerLine(x3, y3, x4, y4)) {
            double distance1 = distance(x1, y1);
            double distance2 = distance(x2, y2);
            if (distance1 <= distance2)
                System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
            else System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
        } else {
            double distance1 = distance(x3, y3);
            double distance2 = distance(x4, y4);

            if (distance1 <= distance2)
                System.out.printf("(%d, %d)(%d, %d)", x3, y3, x4, y4);
            else System.out.printf("(%d, %d)(%d, %d)", x4, y4, x3, y3);
        }
    }


    public static double longerLine(int x1, int y1, int x2, int y2) {
        double line = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return line;
    }

    public static double distance(int x, int y) {
        double result = Math.sqrt(x * x + y * y);
        return result;
    }
}
