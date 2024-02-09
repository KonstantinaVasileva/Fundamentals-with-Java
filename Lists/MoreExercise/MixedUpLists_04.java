package ListsMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> mixedList = new ArrayList<>();

        int minSize = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < minSize; i++) {
            mixedList.add(firstList.get(i));
            mixedList.add(secondList.get(secondList.size() - 1 - i));
        }
        int startNumber;
        int endNumber;
        if (minSize == firstList.size()) {
            startNumber = Math.min(secondList.get(0), secondList.get(1));
            endNumber = Math.max(secondList.get(0), secondList.get(1));
        } else {
            startNumber = Math.min(firstList.get(firstList.size() - 1), firstList.get(firstList.size() - 2));
            endNumber = Math.max(firstList.get(firstList.size() - 1), firstList.get(firstList.size() - 2));
        }
        for (int i = 0; i < mixedList.size(); i++) {
            if (mixedList.get(i) <= startNumber || mixedList.get(i) >= endNumber) {
                mixedList.remove(i);
                i--;
            }
        }

        Collections.sort(mixedList);

        for (int num : mixedList)
            System.out.print(num + " ");

    }
}
