package Arrays_More_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfTheFiled = Integer.parseInt(scanner.nextLine());
        int[] fullIndex = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] filedWithBugs = new int[sizeOfTheFiled];


        for (int j = 0; j < fullIndex.length; j++) {
            if (fullIndex[j] < filedWithBugs.length && fullIndex[j] >= 0)
                filedWithBugs[fullIndex[j]] = 1;

        }
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] moveTheBug = command.split(" ");
            int oldIndex = Integer.parseInt(moveTheBug[0]);
            int move = Integer.parseInt(moveTheBug[2]);

            if (oldIndex < filedWithBugs.length && (oldIndex >= 0) && filedWithBugs[oldIndex] == 1) {

                filedWithBugs[oldIndex] = 0;

                if (command.contains("right")) {
                    int newIndex = move + oldIndex;

                    while (newIndex <= filedWithBugs.length - 1 && filedWithBugs[newIndex] == 1) {
                        newIndex += move;
                    }
                    if (newIndex <= filedWithBugs.length - 1) {
                        filedWithBugs[newIndex] = 1;
                    }

                    //    for (int i = newIndex; i < filedWithBugs.length; i += move) {
                    //        if (filedWithBugs[newIndex] == 0) {
                    //            filedWithBugs[newIndex] = 1;
                    //            break;
                    //        }
                    //    }

                }
                if (command.contains("left")) {
                    int newIndex = oldIndex - move;
                    while (newIndex >= 0 && filedWithBugs[newIndex] != 0) {
                        newIndex -= move;
                    }
                    if (newIndex >= 0) {
                        filedWithBugs[newIndex] = 1;
                    }

                //   for (int i = newIndex; i >= 0; i -= move) {
                //       if (filedWithBugs[newIndex] == 0) {
                //           filedWithBugs[newIndex] = 1;
                //           break;
                //       }
                //   }

                }
            }
            command = scanner.nextLine();
        }
        for (int num : filedWithBugs) {
            System.out.print(num + " ");
        }

    }

}
