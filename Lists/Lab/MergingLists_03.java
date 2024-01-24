package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> numbersFirst = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List <Integer> numbersSecond = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();

        int minSize = Math.min(numbersFirst.size(), numbersSecond.size());

        for (int i = 0; i < minSize; i++) {
            result.add(numbersFirst.get(i));
            result.add(numbersSecond.get(i));
        }
        if (numbersFirst.size() > numbersSecond.size()){
            for (int i = minSize; i < numbersFirst.size(); i++) {
                result.add(numbersFirst.get(i));
            }
        } else  for (int i = minSize; i < numbersSecond.size(); i++) {
            result.add(numbersSecond.get(i));
        }
        System.out.println(Arrays.toString(result.toString().split(" ")).replaceAll("[\\[\\],]", ""));

    }
}
