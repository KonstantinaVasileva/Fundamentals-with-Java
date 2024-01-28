package ListsExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String text = scanner.nextLine();

        while (!text.equals("end")) {
            String[] command = text.split(" ");
            if (command[0].equals("Delete")) {
                numbers.removeAll(Collections.singleton(Integer.parseInt(command[1])));
            }
            if (command[0].equals("Insert")) {
                int element = Integer.parseInt(command[1]);
                int position = Integer.parseInt(command[2]);
                numbers.add(position, element);
            }
            text = scanner.nextLine();
        }

        System.out.println(Arrays.toString(numbers.toString().split(" ")).replaceAll("[\\[\\],]", ""));

        // •	Delete {element} - delete all elements in the array which are equal to the given element
        //•	Insert {element} {position} - insert element at the given position

    }
}
