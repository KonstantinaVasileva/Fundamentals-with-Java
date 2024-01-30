package ListsExercise;

import java.util.*;

public class AppendArrays_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = new ArrayList<>(List.of(scanner.nextLine().split("\\|")));

        Collections.reverse(input);

        System.out.println(input.toString().replaceAll("[\\[\\]]","")
                .trim()
                .replace(",", "")
                .replaceAll("\\s+", " "));

    }
}
