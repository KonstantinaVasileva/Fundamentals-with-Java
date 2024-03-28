package FinalExam;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder encryptedMessage = new StringBuilder(scanner.nextLine());

        while (true) {
            String text = scanner.nextLine();
            if (text.equals("Decode")) {
                break;
            }
            String[] operation = text.split("\\|");
          //  int index = Integer.parseInt(operation[1]);
            switch (operation[0]) {
                case "Move":
                    int index = Integer.parseInt(operation[1]);
                    String part = encryptedMessage.substring(0, index);
                    encryptedMessage.delete(0, index);
                    encryptedMessage.append(part);
                    break;
                case "Insert":
                    int idx = Integer.parseInt(operation[1]);
                    encryptedMessage.insert(idx, operation[2]);
                    break;
                case "ChangeAll":
                    while (encryptedMessage.indexOf(operation[1]) != -1) {
                        int ind = encryptedMessage.indexOf(operation[1]);
                        encryptedMessage.replace(ind, ind + operation[1].length(), operation[2]);
                    }
                    break;
            }
        }
        System.out.println("The decrypted message is: " + encryptedMessage);

    }
}
