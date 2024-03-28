package FinalExam;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder activationKey = new StringBuilder(scanner.nextLine());

        while (true){
            String[] command = scanner.nextLine().split(">>>");
            if (command[0].equals("Generate")){
                break;
            }
            switch (command[0]){
                case "Contains":
                    if (activationKey.indexOf(command[1]) != -1){
                        System.out.printf("%s contains %s\n", activationKey, command[1]);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(command[2]);
                    int endIndex = Integer.parseInt(command[3]);
                    String string = activationKey.substring(startIndex, endIndex);
                    if (command[1].equals("Upper")){
                        activationKey.replace(startIndex, endIndex, string.toUpperCase());
                    } else if (command[1].equals("Lower")) {
                        activationKey.replace(startIndex, endIndex, string.toLowerCase());
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    int startIdx = Integer.parseInt(command[1]);
                    int endIdx = Integer.parseInt(command[2]);
                    activationKey.delete(startIdx, endIdx);
                    System.out.println(activationKey);
                    break;
            }
        }
        System.out.printf("Your activation key is: %s", activationKey);

    }
}
