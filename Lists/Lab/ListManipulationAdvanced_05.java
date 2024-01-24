package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        //•	Contains {number} – check if the list contains the number. If yes, print "Yes", otherwise, print "No such number"
        //•	Print even – print all the numbers that are even separated by a space
        //•	Print odd – print all the numbers that are oddly separated by a space
        //•	Get sum – print the sum of all the numbers
        //•	Filter {condition} {number} – print all the numbers that fulfill that condition. The condition will be either '<', '>', ">=", "<="

        while (!input.equals("end")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Contains":
                    if (numbers.contains(Integer.parseInt(command[1])))
                        System.out.println("Yes");
                    else System.out.println("No such number");
                    break;
                case "Print":
                    for (int num : numbers) {
                        if (command[1].equals("even") && num % 2 == 0) {
                            System.out.print(num + " ");
                        } else if (command[1].equals("odd") && num % 2 == 1)
                            System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;
                    for (int num : numbers)
                        sum += num;
                    System.out.println(sum);
                    break;
                case "Filter":
                    int compareNum = Integer.parseInt(command[2]);
                    switch (command[1]) {
                        case ">":
                            bigger(numbers, compareNum);
                            break;
                        case ">=":
                            biggerOrEqual(numbers, compareNum);
                            break;
                        case "<":
                            smaller(numbers, compareNum);
                            break;
                        case "<=":
                            smallerOrEqual(numbers, compareNum);
                            break;
                    }
                    break;

            }
            input = scanner.nextLine();
        }

    }

    public static void bigger(List<Integer> numbers, int compareNum) {
        for (int num : numbers)
            if (num > compareNum)
                System.out.print(num + " ");
        System.out.println();
    }

    public static void biggerOrEqual(List<Integer> numbers, int compareNum) {
        for (int num : numbers)
            if (num >= compareNum)
                System.out.print(num + " ");
        System.out.println();
    }

    public static void smaller(List<Integer> numbers, int compareNum) {
        for (int num : numbers)
            if (num < compareNum)
                System.out.print(num + " ");
        System.out.println();
    }

    public static void smallerOrEqual(List<Integer> numbers, int compareNum) {
        for (int num : numbers)
            if (num <= compareNum)
                System.out.print(num + " ");
        System.out.println();
    }
}
