package MidExam;

import java.util.*;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = Arrays.stream(numbers).sum();

        double averageNumber = sum * 1.0 / numbers.length;
        List<Integer> topNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number > averageNumber) {
                topNumbers.add(number);
            }
        }
        Collections.sort(topNumbers);
        if (topNumbers.size() >= 5) {
            for (int i = topNumbers.size() - 1; i >= topNumbers.size() - 5; i--) {
                System.out.print(topNumbers.get(i) + " ");
            }
        } else if (topNumbers.isEmpty()) {
            System.out.println("No");
        } else for (int num = topNumbers.size() - 1; num >= 0; num--) {
            System.out.print(topNumbers.get(num) + " ");
        }
    }
}
