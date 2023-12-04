package BasicSyntax_ConditionalStatementsandLoops;

import java.util.Scanner;

public class BackIn30Minutes_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());

        min = min + 30;

        if (min > 59)
        {
            min -= 60;
            hours ++;
            if (hours > 23)
                hours -= 24;
        }
        System.out.printf("%d:%02d", hours, min);

    }
}
