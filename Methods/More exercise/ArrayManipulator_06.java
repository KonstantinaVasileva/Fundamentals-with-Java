package Methods_MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class ArrayManipulator_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayOfNumber = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            if (command.contains("exchange")) {
                if (index(command) >= arrayOfNumber.length || index(command) < 0)
                    System.out.println("Invalid index");
                else {
                    exchange(arrayOfNumber, index(command));
                }
            } else if (command.contains("max")) {
                if (max(arrayOfNumber, command) == -1) {
                    System.out.println("No matches");
                } else
                    System.out.println(max(arrayOfNumber, command));
            } else if (command.contains("min")) {
                if (min(arrayOfNumber, command) == -1) {
                    System.out.println("No matches");
                } else
                    System.out.println(min(arrayOfNumber, command));
            } else if (command.contains("first")) {
                if (index(command) > arrayOfNumber.length)
                    System.out.println("Invalid count");
                else
                    System.out.println(Arrays.toString(first(arrayOfNumber, command)));
            } else if (command.contains("last")) {
                if (index(command) > arrayOfNumber.length)
                    System.out.println("Invalid count");
                else
                    System.out.println(Arrays.toString(last(arrayOfNumber, command)));
            }
            command = scanner.nextLine();
        }
        System.out.println(Arrays.toString(arrayOfNumber));

    }

    public static int[] exchange(int[] numbers, int index) {
        int[] tempArr = new int[index + 1];
        System.arraycopy(numbers, 0, tempArr, 0, index + 1);
        for (int i = 0; i < numbers.length - index - 1; i++) {
            numbers[i] = numbers[i + index + 1];
        }
        int j = 0;
        for (int i = numbers.length - index - 1; i < numbers.length; i++) {
            numbers[i] = tempArr[j];
            j++;
        }
        return numbers;

    }

    public static int max(int[] numbers, String command) {
        int maxEven = MIN_VALUE;
        int maxOdd = MIN_VALUE;
        int evenIndex = -1;
        int oddIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0 && numbers[i] >= maxEven) {
                evenIndex = i;
                maxEven = numbers[i];
            } else if (numbers[i] >= maxOdd) {
                oddIndex = i;
                maxOdd = numbers[i];
            }
        }
        if (command.contains("even")) {
            return evenIndex;
        }
        return oddIndex;
    }

    public static int min(int[] numbers, String command) {
        int minEven = MAX_VALUE;
        int minOdd = MAX_VALUE;
        int evenIndex = -1;
        int oddIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0 && numbers[i] <= minEven) {
                evenIndex = i;
                minEven = numbers[i];
            } else if (numbers[i] <= minOdd) {
                oddIndex = i;
                minOdd = numbers[i];
            }
        }
        if (command.contains("even")) {
            return evenIndex;
        }
        return oddIndex;
    }

    public static int[] first(int[] numbers, String command) {
        int length = index(command);
        int[] empty = {};

        int[] odd = new int[Math.min(length, countOddEven(numbers)[1])];
        int[] even = new int[Math.min(length, countOddEven(numbers)[0])];
        int i = 0;
        int j = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                if (i >= even.length)
                    continue;
                even[i] = num;
                i++;
            } else {
                if (j >= odd.length)
                    continue;
                odd[j] = num;
                j++;
            }
        }
        if (command.contains("odd")) {
            if (j == 0) {
                return empty;
            }
            return odd;
        }
        if (i == 0) {
            return empty;
        }
        return even;
    }

    public static int[] last(int[] numbers, String command) {
        int length = index(command);
        int[] empty = {};

        int[] odd = new int[Math.min(length, countOddEven(numbers)[1])];
        int[] even = new int[Math.min(length, countOddEven(numbers)[0])];
        int i = even.length - 1;
        int j = odd.length - 1;
        for (int num = numbers.length - 1; num >= 0; num--) {
            if (numbers[num] % 2 == 0) {
                if (i < 0)
                    continue;
                even[i] = numbers[num];
                i--;
            } else {
                if (j < 0)
                    continue;
                odd[j] = numbers[num];
                j--;
            }
        }
        if (command.contains("odd")) {
            if (j == length - 1) {
                return empty;
            }
            return odd;
        }
        if (i == length - 1) {
            return empty;
        }
        return even;
    }

    public static int index(String command) {
        int[] index = new int[2];
        int j = 0;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == ' ') {
                index[j] = i;
                j++;
            }
        }
        if (index[1] == 0) {
            command = command.substring(index[0] + 1);
        } else
            command = command.substring(index[0] + 1, index[1]);
        return Integer.parseInt(command);
    }

    public static int[] countOddEven(int[] numbers) {
        int[] evenOdd = new int[2];
        for (int num : numbers) {
            if (num % 2 == 0)
                evenOdd[0]++;
            else evenOdd[1]++;

        }
        return evenOdd;
    }
}