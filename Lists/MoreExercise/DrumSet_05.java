package ListsMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class DrumSet_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> copyOfDrumSet = new ArrayList<>(drumSet);

        String command = scanner.nextLine();

        while (!command.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(command);
            for (int i = 0; i < drumSet.size(); i++) {
                drumSet.add(i, drumSet.get(i) - hitPower);
                drumSet.remove(i + 1);
                if (drumSet.get(i) <= 0) {
                    if (money - copyOfDrumSet.get(i) * 3 < 0) {
                        drumSet.remove(i);
                        copyOfDrumSet.remove(i);
                        i--;
                    } else {
                        drumSet.add(i, copyOfDrumSet.get(i));
                        drumSet.remove(i + 1);
                        money -= drumSet.get(i) * 3;
                    }
                }
            }

            command = scanner.nextLine();
        }
        for (int drum:drumSet)
            System.out.print(drum + " ");
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", money);
    }
}
