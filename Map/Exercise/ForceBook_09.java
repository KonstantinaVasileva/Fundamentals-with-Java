package MapsLambdaAndStreamAPI_Exercise;

import java.util.*;

public class ForceBook_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        LinkedHashMap<String, List<String>> users = new LinkedHashMap<>();

        while (!text.equals("Lumpawaroo")) {
            if (text.contains("|")) {
                String side = text.split(" \\| ")[0];
                String user = text.split(" \\| ")[1];
                if (!users.containsKey(side) && !isExist(user, users)) {
                    List<String> temp = new ArrayList<>();
                    temp.add(user);
                    users.put(side, temp);
                } else if (!isExist(user, users)) {
                    users.get(side).add(user);
                }
            }
            if (text.contains("->")) {
                String user = text.split(" -> ")[0];
                String side = text.split(" -> ")[1];
                if (isExist(user, users)) {
                    for (Map.Entry<String, List<String>> entry : users.entrySet()) {
                        entry.getValue().remove(user);
                    }
                    users.putIfAbsent(side, new ArrayList<>());
                    users.get(side).add(user);
                } else {
                    users.putIfAbsent(side, new ArrayList<>());
                    users.get(side).add(user);

                }
                System.out.printf("%s joins the %s side!\n", user, side);
            }
            text = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : users.entrySet()) {
            if (entry.getValue().isEmpty()){
                continue;
            }
            System.out.println("Side: " + entry.getKey() + ", Members: " + entry.getValue().size() + "\n" +
                    "! " + String.join("\n! ", entry.getValue()));
        }
    }

    public static boolean isExist(String user, LinkedHashMap<String, List<String>> users) {
        for (List<String> userList : users.values()) {
            if (userList.contains(user)) {
                return true;
            }
        }
        return false;
    }
}
