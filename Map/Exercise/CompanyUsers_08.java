package MapsLambdaAndStreamAPI_Exercise;

import java.util.*;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> employees = new LinkedHashMap<>();

        while (true) {
            String text = scanner.nextLine();
            if (text.equals("End")) {
                break;
            }
            String companyName = text.split(" -> ")[0];
            String id = text.split(" -> ")[1];

            employees.putIfAbsent(companyName, new ArrayList<>());
            if (employees.get(companyName).contains(id)){
                continue;
            } else {
                employees.get(companyName).add(id);
            }
        }
        for (Map.Entry<String, List<String>> entry: employees.entrySet()){
            System.out.println(entry.getKey());
            System.out.println("-- " + String.join("\n-- ",entry.getValue()));
        }

    }
}
