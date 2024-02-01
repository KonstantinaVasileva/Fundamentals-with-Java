package Arrays_More_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lineOfNum = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxLength = 0;
        int lastIndx = -1;
        int[] len = new int[lineOfNum.length];
        int[] prev = new int[lineOfNum.length];

        for (int p = 0; p < lineOfNum.length; p++) {
            prev[p] = -1;
            len[p] = 1;
            for (int left = 0; left < p; left++) {
                if (lineOfNum[left] < lineOfNum[p] && len[left] + 1 > len[p]) {
                    len[p] = 1 + len[left];
                    prev[p] = left;
                }
            }
            if (len[p] > maxLength) {
                maxLength = len[p];
                lastIndx = p;
            }
        }
            int[] lis = new int[maxLength];
            int index = maxLength - 1;
            while (lastIndx != -1) {
                lis [index] = lineOfNum[lastIndx];
                index--;
                lastIndx = prev[lastIndx];
            }
            for (int number:lis) {
                System.out.print(number + " ");
            }


    }
}