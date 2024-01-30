package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream((scanner.nextLine().split(" "))).collect(Collectors.toList());

        String text = scanner.nextLine();

        while (!text.equals("3:1")) {
            String[] command = text.split(" ");
            int startIndex = Integer.parseInt(command[1]);
            int endIndex = Integer.parseInt(command[2]);
            switch (command[0]) {
                case "merge":
                    if (startIndex >= input.size() || endIndex < 0)
                        break;
                    if (startIndex < 0)
                        startIndex = 0;
                    if (endIndex >= input.size())
                        endIndex = input.size() - 1;
                    //  List<String> mergeList = input.subList(startIndex, endIndex + 1);
                    //  StringBuilder mergeString = new StringBuilder();
                    String mergeString = "";
                    for (int i = startIndex; i <= endIndex; i++) {
                        //  mergeString.append(mergeList.get(i - startIndex));
                        mergeString += input.get(i);

                    }
                    for (int i = startIndex; i <= endIndex; i++) {
                        input.remove(startIndex);
                    }

                    input.add(startIndex, mergeString);
                    break;
                case "divide":
                    int partition = endIndex;
                    String divideList = input.get(startIndex);
                    input.remove(startIndex);
                    int lengthOfPart = divideList.length() / partition;
                    String tempElement;
                   /* if (reminder == 0) {
                        for (int i = 0; i < partition; i++) {
                            tempElement = "";
                            for (int j = 0; j < lengthOfPart; j++) {
                                tempElement += divideList.charAt(j + i * lengthOfPart);
                            }
                            input.add(startIndex + i, tempElement);
                        }
                    } else {
                        for (int i = 0; i < partition - 1; i++) {
                            tempElement = "";
                            for (int j = 0; j < lengthOfPart; j++) {
                                tempElement += divideList.charAt(j + i * partition);
                            }
                            input.add(startIndex + i, tempElement);
                        }
                        tempElement = "";
                        for (int i = lengthOfPart * (partition - 1); i < divideList.length(); i++) {
                            tempElement += divideList.charAt(i);
                        }
                        input.add(startIndex + partition - 1, tempElement);
                        input.remove(startIndex + partition);
                    }
                    break;*/
                    for (int i = 0; i < partition - 1; i++) {
                        tempElement = "";
                        for (int j = 0; j < lengthOfPart; j++) {
                            tempElement += divideList.charAt(j + i * lengthOfPart);
                        }
                        input.add(startIndex + i, tempElement);
                    }
                    tempElement = "";
                    for (int i = (partition - 1) * lengthOfPart ; i < divideList.length(); i++) {
                        tempElement += divideList.charAt(i);
                    }
                    input.add(startIndex + partition - 1, tempElement);

            }

            text = scanner.nextLine();
        }
        for (String element : input)
            System.out.print(element + " ");

    }
}
