package Methods_MoreExercise;

import java.util.Scanner;

public class CenterPoint_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        double distance1 = distance(x1, y1);
        double distance2 = distance(x2, y2);

        if (distance1 <= distance2)
            System.out.printf("(%d, %d)", x1, y1);
        else System.out.printf("(%d, %d)", x2, y2);

    }

    public static double distance(int x, int y) {
        double result = Math.sqrt(x * x + y * y);
        return result;
    }
}
