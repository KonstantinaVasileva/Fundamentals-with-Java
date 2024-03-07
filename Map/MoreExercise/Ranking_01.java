package MapsLambdaAndStreamAPI_MoreExercise;

import java.util.*;

public class Ranking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contestPassword = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, Integer>> userContestPoints = new TreeMap<>();


        while (true) {
            String text = scanner.nextLine();
            if (text.equals("end of contests")) {
                break;
            }
            String contest = text.split(":")[0];
            String password = text.split(":")[1];
            contestPassword.put(contest, password);
        }


        while (true) {
            String text = scanner.nextLine();
            if (text.equals("end of submissions")) {
                break;
            }
            String contest = text.split("=>")[0];
            String password = text.split("=>")[1];
            String username = text.split("=>")[2];
            int points = Integer.parseInt(text.split("=>")[3]);

            if (contestPassword.containsKey(contest)
                    && contestPassword.get(contest).equals(password)) {
                LinkedHashMap<String, Integer> contestPoints = new LinkedHashMap<>();
                contestPoints.put(contest, points);

                if (!userContestPoints.containsKey(username)) {

                    userContestPoints.put(username, contestPoints);
                } else if (userContestPoints.get(username).containsKey(contest) &&
                        userContestPoints.get(username).get(contest) < points) {
                    userContestPoints.get(username).put(contest, points);
                } else if (!userContestPoints.get(username).containsKey(contest)) {
                    userContestPoints.get(username).put(contest, points);
                }
            }
        }
        Map<String, Integer> userBestPoints = new TreeMap<>();

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : userContestPoints.entrySet()) {
            userBestPoints.putIfAbsent(entry.getKey(), 0);
            for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                userBestPoints.put(entry.getKey(), userBestPoints.get(entry.getKey()) + entry1.getValue());
            }
        }

        int maxPoint = Collections.max(userBestPoints.values());

        for (Map.Entry<String, Integer> entry : userBestPoints.entrySet()) {
            if (entry.getValue() == maxPoint) {
                System.out.printf("Best candidate is %s with total %s points.\n",
                        entry.getKey(), maxPoint);
            }
        }
        System.out.println("Ranking: ");


        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : userContestPoints.entrySet()) {
            System.out.println(entry.getKey());

            List<Map.Entry<String, Integer>> list = new LinkedList<>(entry.getValue().entrySet());

            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o2.getValue()).compareTo(o1.getValue());
                }
            });
            Map<String, Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry1 : list) {
                sortedMap.put(entry1.getKey(), entry1.getValue());
            }

            for (Map.Entry<String, Integer> entry1 : sortedMap.entrySet()) {
                System.out.printf("#  %s -> %s\n", entry1.getKey(), entry1.getValue());
            }
        }
    }
}
