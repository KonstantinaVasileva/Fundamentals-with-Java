package Arrays_More_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int[] bestDna = new int[num];

        int bestSequenceIndex = -1;
        int bestLongOne = 0;
        int row = 0;
        int bestRow = 0;

        String input = scanner.nextLine();
        while (!input.equals("Clone them!")) {

            int[] dna = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int count = 0;   // дължина на поредица единици, до която сме стигнали
            int bestCurrentIndex = 0;  // индекс, от който започва най–дългата поредица единици
            int longOne = 0;  //най - дългата поредица от единици в даденото ДНК
            row++;   // ред на ДНК

            for (int i = 0; i <= dna.length; i++) {
                if (i < dna.length && dna[i] == 1) {
                    count++;
                } else {
                    if (longOne < count) {
                        longOne = count;
                        bestCurrentIndex = i - longOne;
                    }

                    count = 0;
                }
            }
         //   if (bestDna == dna) {
         //       bestCount = count;
         //   }
            if (longOne > bestLongOne) {
                bestLongOne = longOne;
                bestSequenceIndex = bestCurrentIndex;
                bestDna = dna;
                bestRow = row;
            } else if (longOne == bestLongOne) {
                if (bestSequenceIndex > bestCurrentIndex) {
                    bestDna = dna;
                    bestSequenceIndex = bestCurrentIndex;
                    bestRow = row;
                } else if (bestSequenceIndex == bestCurrentIndex && Arrays.stream(bestDna).sum() < Arrays.stream(dna).sum()) {
                    bestDna = dna;
                    bestRow = row;
                }
            }
            input = scanner.nextLine();

        }
        if (bestSequenceIndex == -1) {
            return;
        }
        System.out.printf("Best DNA sample %d with sum: %d.\n", bestRow, Arrays.stream(bestDna).sum());
        for (int number : bestDna) {
            System.out.print(number + " ");
        }

    }
}