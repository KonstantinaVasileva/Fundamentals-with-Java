package Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayOfInt = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            if (input.equals("decrease")) {
                for (int i = 0; i < arrayOfInt.length; i++) {
                    arrayOfInt[i] -= 1;
                }
                input = scanner.nextLine();
                continue;
            }
            int index = input.indexOf(" ");
            String command = input.substring(0, index);
            if (command.equals("swap")) {
                String firsNum = input.substring(index + 1);
                int indexFirstNum = firsNum.indexOf(" ");
                int n1 = Integer.parseInt(firsNum.substring(0, indexFirstNum));
                int n2 = Integer.parseInt(firsNum.substring(indexFirstNum + 1));

                int temp = arrayOfInt[n1];
                arrayOfInt[n1] = arrayOfInt[n2];
                arrayOfInt[n2] = temp;
            }
            if (command.equals("multiply")) {
                String firsNum = input.substring(index + 1);
                int indexFirstNum = firsNum.indexOf(" ");
                int n1 = Integer.parseInt(firsNum.substring(0, indexFirstNum));
                int n2 = Integer.parseInt(firsNum.substring(indexFirstNum + 1));
                arrayOfInt[n1] = arrayOfInt[n1] * arrayOfInt[n2];
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < arrayOfInt.length; i++) {
            System.out.print(arrayOfInt[i]);
            if (i!= arrayOfInt.length-1)
                System.out.print(", ");
        }

    }
}
