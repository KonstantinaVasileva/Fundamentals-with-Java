package MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, String> parking = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] command = scanner.nextLine().split(" ");
            String username = command[1];

            switch (command[0]) {
                case "register":
                    String licensePlateNumber = command[2];
                    if (parking.containsKey(username)) {
                        System.out.printf("ERROR: already registered with plate number %s\n", licensePlateNumber);
                    } else {
                        parking.put(username, licensePlateNumber);
                        System.out.printf("%s registered %s successfully\n", username, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (parking.containsKey(username)) {
                        parking.remove(username);
                        System.out.printf("%s unregistered successfully\n", username);
                    } else {
                        System.out.printf("ERROR: user %s not found\n", username);
                    }
                    break;
            }
        }
        for (Map.Entry<String, String> entry : parking.entrySet()) {
            System.out.printf("%s => %s\n", entry.getKey(), entry.getValue());
        }

    }
}
