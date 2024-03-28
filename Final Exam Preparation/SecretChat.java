package FinalExam;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        while (true){
            String[] instruction = scanner.nextLine().split(":\\|:");
            if (instruction[0].equals("Reveal")){
                break;
            }
            switch (instruction[0]){
                case "InsertSpace":
                    message.insert(Integer.parseInt(instruction[1]), " ");
                    System.out.println(message);
                    break;
                case "Reverse":
                    int index = message.indexOf(instruction[1]);
                    if (index != -1){
                        StringBuilder substring = new StringBuilder(instruction[1]);
                        message.delete(index, index + instruction[1].length());
                        message.append(substring.reverse());
                        System.out.println(message);
                    }
                    else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    while (message.indexOf(instruction[1]) != -1){
                        int idx = message.indexOf(instruction[1]);
                        message.replace(idx, idx + instruction[1].length(), instruction[2]);
                    }
                    System.out.println(message);
                    break;
            }
        }

        System.out.printf("You have a new text message: %s", message);
    }
}
