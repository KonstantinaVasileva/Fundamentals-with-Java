package MapsLambdaAndStreamAPI_Exercise;

import java.util.*;

public class Courses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> courses = new LinkedHashMap<>();

        while (true) {
            String text = scanner.nextLine();
            if (text.equals("end")) {
                break;
            }
            String course = text.split(" : ")[0];
            String student = text.split(" : ")[1];

            courses.putIfAbsent(course, new ArrayList<>());
            courses.get(course).add(student);
        }
        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue().size());
            System.out.println("-- " + String.join("\n-- ", entry.getValue()));
        }

    }
}
