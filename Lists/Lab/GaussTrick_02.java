package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        int size = numbers.size();

        for (int i = 0; i < size/2; i++) {
            numbers.set(i, (numbers.get(i) + numbers.get(numbers.size()-1)));

            numbers.remove(numbers.size()-1);
        }
        System.out.println(Arrays.toString(numbers.toString().split(" ")).replaceAll("[\\[\\],]", ""));
    }
}
