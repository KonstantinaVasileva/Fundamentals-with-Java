package FinalExam;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder destination = new StringBuilder(scanner.nextLine());

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Travel")) {
                break;
            }
            String[] command = input.split(":");

            switch (command[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(command[1]);
                    String text = command[2];
                    if (isValid(index, destination.length())) {
                        destination.insert(index, text);
                    }
                    System.out.println(destination);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    if (isValid(startIndex, destination.length()) && isValid(endIndex, destination.length())) {
                        destination.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(destination);
                    break;
                case "Switch":
                    String oldStop = command[1];
                    String newStop = command[2];
                    int idx = destination.indexOf(oldStop);
                    if(idx!= -1){
                        destination.replace(idx, idx + oldStop.length(), newStop);
                    }
                    System.out.println(destination);
                    break;
            }
        }
        System.out.printf("Ready for world tour! Planned stops: %s", destination);
    }

    public static boolean isValid(int index, int length) {
        return index >= 0 && index < length;
    }
}
