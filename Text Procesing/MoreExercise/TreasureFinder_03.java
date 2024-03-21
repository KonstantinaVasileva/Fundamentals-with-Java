package TextProcessing.More_Exercise;

import java.util.Scanner;

public class TreasureFinder_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] number = scanner.nextLine().split(" ");

        while (true) {
            String text = scanner.nextLine();
            if (text.equals("find")) {
                break;
            }
            boolean isOpen = false;
            boolean isBegin = false;

            StringBuilder type = new StringBuilder();
            StringBuilder coordination = new StringBuilder();

            for (int i = 0; i < text.length(); i++) {
                int index = i % number.length;
                int digit = Integer.parseInt(number[index]);
                char ch = (char) (text.charAt(i) - digit);

                if (ch == '&') {
                    isOpen = !isOpen;
                    continue;
                }
                if (isOpen) {
                    type.append(ch);
                }
                if (ch == '<'){
                    isBegin = true;
                    continue;
                }
                if (ch == '>'){
                    isBegin = false;
                }
                if (isBegin){
                    coordination.append(ch);
                }
            }
            System.out.printf("Found %s at %s\n", type, coordination);
        }

    }
}
