package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //•	Add {number} – add a number to the end of the list
        //•	Remove {number} – remove a number from the list
        //•	RemoveAt {index} – remove a number at a given index
        //•	Insert {number} {index} – insert a number at a given index

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String [] command = input.split(" ");
            int num = Integer.parseInt(command[1]);
            switch (command[0]){
                case "Add":
                    numbers.add(num);
                    break;
                case "Remove":
                    numbers.remove(Integer.valueOf(num));
                    break;
                case "RemoveAt":
                    numbers.remove(numbers.get(num));
                    break;
                case "Insert":
                    int idx = Integer.parseInt(command[2]);
                    numbers.add(idx, num);
            }
            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(numbers.toString().split(" ")).replaceAll("[\\[\\],]", ""));

    }
}
