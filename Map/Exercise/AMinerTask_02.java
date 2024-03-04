package MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        while (true){
            String resource = scanner.nextLine();
            if (resource.equals("stop")){
                break;
            }
            int quantity = Integer.parseInt(scanner.nextLine());

            resources.putIfAbsent(resource, 0);
            resources.put(resource, resources.get(resource) + quantity);
        }

        for (Map.Entry entry: resources.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
