package MapsLambdaAndStreamAPI_MoreExercise;

import java.util.*;

public class MOBAChallenger_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, TreeMap<String, Integer>> playerPool = new LinkedHashMap<>();

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Season end")) {
                break;
            }
            TreeMap<String, Integer> positionSkill = new TreeMap<>();
            if (command.contains("->")) {
                String player = command.split(" -> ")[0];
                String position = command.split(" -> ")[1];
                int skill = Integer.parseInt(command.split(" -> ")[2]);
                if (!playerPool.containsKey(player)) {
                    positionSkill.put(position, skill);
                    playerPool.put(player, positionSkill);
                } else if (!playerPool.get(player).containsKey(position)) {
                    // positionSkill.put(position, skill);
                    playerPool.get(player).put(position, skill);
                } else if (playerPool.get(player).get(position) < skill) {
                    playerPool.get(player).put(position, skill);
                }

            } else if (command.contains("vs")) {
                String firstPlayer = command.split(" vs ")[0];
                String secondPlayer = command.split(" vs ")[1];
                if (playerPool.containsKey(firstPlayer) && playerPool.containsKey(secondPlayer)) {
                    Map<String, Integer> firstPlayerPositionSkill = playerPool.get(firstPlayer);
                    Map<String, Integer> secondPlayerPositionSkill = playerPool.get(secondPlayer);
                    for (Map.Entry<String, Integer> firstEntry : firstPlayerPositionSkill.entrySet()) {
                        for (Map.Entry<String, Integer> secondEntry : secondPlayerPositionSkill.entrySet()) {
                            if (firstEntry.getKey().equals(secondEntry.getKey())) {
                                if (firstEntry.getValue() > secondEntry.getValue()) {
                                    playerPool.remove(secondPlayer);
                                } else if (firstEntry.getValue() < secondEntry.getValue()) {
                                    playerPool.remove(firstPlayer);
                                }
                            }
                        }
                    }
                }
            }
        }

        Map<String, Integer> playerTotalSkill = new TreeMap<>();
        playerPool.entrySet().stream().forEach(entry -> {
            playerTotalSkill.putIfAbsent(entry.getKey(), 0);
            entry.getValue().entrySet().stream()
                    .forEach(entry1 -> playerTotalSkill.put(entry.getKey(), playerTotalSkill.get(entry.getKey()) + entry1.getValue()));
        });

        playerTotalSkill.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    System.out.printf("%s: %s skill\n", entry.getKey(), entry.getValue());
                    Map<String, Integer> positionSkill = new TreeMap<>();
                    positionSkill = playerPool.get(entry.getKey());
                    positionSkill.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .forEach(e -> System.out.printf("- %s <::> %s\n", e.getKey(), e.getValue()));
                });
    }
}
