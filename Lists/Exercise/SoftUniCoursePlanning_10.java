package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String text = scanner.nextLine();


        while (!text.equals("course start")) {
            List<String> command = Arrays.stream(text.split(":")).collect(Collectors.toList());
            switch (command.get(0)) {
                case "Add":
                    if (!schedule.contains(command.get(1))) {
                        schedule.add(command.get(1));
                    }
                    break;
                case "Insert":
                    int idx = Integer.parseInt(command.get(2));
                    if (idx < 0 || idx > schedule.size())
                        break;
                    if (!schedule.contains(command.get(1)))
                        schedule.add(idx, command.get(1));
                    break;
                case "Swap":
                    int firIdx = schedule.indexOf(command.get(1));
                    int secIdx = schedule.indexOf(command.get(2));
                    if (schedule.contains(command.get(1)) && schedule.contains(command.get(2))) {
                        schedule.add(firIdx, command.get(2));
                        schedule.remove(firIdx + 1);
                        schedule.add(secIdx, command.get(1));
                        schedule.remove(secIdx + 1);
                    }
                   for (int i = 0; i < schedule.size(); i++) {
                        if (schedule.get(i).contains(command.get(1)) && schedule.get(i).contains("Exercise")) {
                            schedule.remove(i);
                            schedule.add(schedule.indexOf(command.get(1)) + 1, command.get(1) + "-Exercise");
                        }
                        if (schedule.get(i).contains(command.get(2)) && schedule.get(i).contains("Exercise")) {
                            schedule.remove(i);
                            schedule.add(schedule.indexOf(command.get(2)) + 1, command.get(2) + "-Exercise");
                        }
                    }
                   /* if (schedule.get(firIdx + 1).contains("Exercise")){
                        schedule.add(secIdx + 1, schedule.get(firIdx + 1));
                        schedule.remove(firIdx + 1);
                    }*/
                    break;
                case "Remove":
                    if (schedule.contains(command.get(1)))
                        schedule.remove(command.get(1));
                    for (int i = 0; i < schedule.size(); i++) {
                        if (schedule.get(i).contains(command.get(1)) && schedule.get(i).contains("Exercise"))
                            schedule.remove(i);
                    }
                    break;
                case "Exercise":
                    if (schedule.contains(command.get(1) + "-Exercise"))
                        break;
                    if (schedule.contains(command.get(1))) {
                        schedule.add(schedule.indexOf(command.get(1)) + 1, command.get(1) + "-Exercise");
                    } else {
                        schedule.add(command.get(1));
                        schedule.add(command.get(1) + "-Exercise");
                    }
            }
            text = scanner.nextLine();
        }
        for (int i = 0; i < schedule.size(); i++) {
            System.out.println((i + 1) + "." + schedule.get(i));
        }

    }
}
