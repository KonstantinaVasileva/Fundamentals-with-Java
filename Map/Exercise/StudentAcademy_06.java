package MapsLambdaAndStreamAPI_Exercise;

import java.util.*;

public class StudentAcademy_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<Double>> students = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }
        for (Map.Entry<String, List<Double>> entry: students.entrySet()){
            double averageGrade = (entry.getValue().stream().mapToDouble(e->e).sum())/entry.getValue().size();
            if (averageGrade >= 4.5){
                System.out.printf("%s -> %.2f\n", entry.getKey(), averageGrade);
            }

        }
    }
}
