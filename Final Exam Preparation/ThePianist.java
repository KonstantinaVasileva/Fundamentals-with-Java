package FinalExam;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPieces = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, String>> pieces = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfPieces; i++) {
            String[] piece = scanner.nextLine().split("\\|");
            Map<String, String> nameKey = new LinkedHashMap<>();
            nameKey.put(piece[1], piece[2]);
            pieces.put(piece[0], nameKey);
        }

        while (true){
            String text = scanner.nextLine();
            if (text.equals("Stop")){
                break;
            }
            String[] command = text.split("\\|");
            Map<String, String> nameKey = new LinkedHashMap<>();
            switch (command[0]){
                case "Add":
                    if (pieces.containsKey(command[1])){
                        System.out.println(command[1] + " is already in the collection!");
                    } else {
                        nameKey.put(command[2], command[3]);
                        pieces.put(command[1], nameKey);
                        System.out.printf("%s by %s in %s added to the collection!\n", command[1], command[2], command[3]);
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(command[1])){
                        pieces.remove(command[1]);
                        System.out.println("Successfully removed " + command[1] + "!");
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", command[1]);
                    }
                    break;
                case "ChangeKey":
                    if (pieces.containsKey(command[1])){
                        nameKey = pieces.get(command[1]);
                        String name = nameKey.keySet().toString().replace("[", "").replace("]", "");
                        nameKey.put(name, command[2]);
                        pieces.put(command[1], nameKey);
                        System.out.printf("Changed the key of %s to %s!\n", command[1], command[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", command[1]);
                    }
                    break;
            }
        }
        //"{Piece} -> Composer: {composer}, Key: {key}"
        for (Map.Entry<String, Map<String, String>> entry: pieces.entrySet()){
            for (Map.Entry<String, String > entry1:entry.getValue().entrySet()){
                System.out.printf("%s -> Composer: %s, Key: %s\n", entry.getKey(), entry1.getKey(), entry1.getValue());
            }
        }

    }
}
