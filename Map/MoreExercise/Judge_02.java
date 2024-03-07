package MapsLambdaAndStreamAPI_MoreExercise;

import java.util.*;

public class Judge_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, TreeMap<String, Integer>> contestUsernamePoints = new LinkedHashMap<>();

        while (true) {
            String text = scanner.nextLine();
            if (text.equals("no more time")) {
                break;
            }
            String username = text.split(" -> ")[0];
            String contest = text.split(" -> ")[1];
            int points = Integer.parseInt(text.split(" -> ")[2]);

            if (!contestUsernamePoints.containsKey(contest)) {
                TreeMap<String, Integer> usernamePoints = new TreeMap<>();
                usernamePoints.put(username, points);
                contestUsernamePoints.put(contest, usernamePoints);
            } else if (contestUsernamePoints.get(contest).containsKey(username)
                    && contestUsernamePoints.get(contest).get(username) < points) {
                contestUsernamePoints.get(contest).put(username, points);
            } else if (!contestUsernamePoints.get(contest).containsKey(username)) {
                contestUsernamePoints.get(contest).put(username, points);
            }
        }
        for (Map.Entry<String, TreeMap<String, Integer>> entry : contestUsernamePoints.entrySet()) {

            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " participants");

            List<Map.Entry<String, Integer>> list = new ArrayList<>(entry.getValue().entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o2.getValue()).compareTo(o1.getValue());
                }
            });
            Map<String, Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry1 : list) {
                sortedMap.put(entry1.getKey(), entry1.getValue());
            }
            int n = 0;
            for (Map.Entry<String, Integer> entry1 : sortedMap.entrySet()) {
                n++;
                System.out.printf("%s. %s <::> %s\n", n, entry1.getKey(), entry1.getValue());
            }
        }
        System.out.println("Individual standings:");

        Map<String, Integer> usernamePoints = new TreeMap<>();
        for (Map.Entry<String, TreeMap<String, Integer>> entry : contestUsernamePoints.entrySet()) {
            for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                usernamePoints.putIfAbsent(entry1.getKey(), 0);
                usernamePoints.put(entry1.getKey(), usernamePoints.get(entry1.getKey()) + entry1.getValue());
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(usernamePoints.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry1 : list) {
            sortedMap.put(entry1.getKey(), entry1.getValue());
        }
        int n = 0;
        for (Map.Entry<String, Integer> entry1 : sortedMap.entrySet()) {
            n++;
            System.out.printf("%s. %s -> %s\n", n, entry1.getKey(), entry1.getValue());
        }
    }
}
