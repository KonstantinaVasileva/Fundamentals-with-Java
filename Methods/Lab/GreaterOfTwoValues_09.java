package Methods;

import java.util.Scanner;

public class GreaterOfTwoValues_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String firstArg = scanner.nextLine();
        String secondArg = scanner.nextLine();

        System.out.println(getMax(type, firstArg, secondArg));

    }

    public static String getMax(String type, String firstArg, String secondArg) {
        String max = "";
        switch (type) {
            case "int":
                int firstInt = Integer.parseInt(firstArg);
                int secondInt = Integer.parseInt(secondArg);
                if (firstInt > secondInt) {
                    max = firstArg;
                } else max = secondArg;
                break;
            case "char":
                char firstCh = firstArg.charAt(0);
                char secondCh = firstArg.charAt(0);
                if (firstCh > secondCh) {
                    max = firstArg;
                } else max = secondArg;
                break;
            case "string":
                if (firstArg.compareTo(secondArg) > 0) {
                    max = firstArg;
                } else max = secondArg;
                break;

        }
        return max;
    }

}
