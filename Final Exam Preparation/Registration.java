package FinalExam;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        while (true) {
            String text = scanner.nextLine();
            if (text.equals("Registration")) {
                break;
            }
            String[] command = text.split(" ");
            switch (command[0]) {
                case "Letters":
                    if (command[1].equals("Lower")) {
                        username = username.toLowerCase();
                    } else if (command[1].equals("Upper")) {
                        username = username.toUpperCase();
                    }
                    System.out.println(username);
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    if (startIndex > 0 && startIndex < username.length()
                            && endIndex > 0 && endIndex < username.length()) {
                        StringBuilder reverse = new StringBuilder(username.substring(startIndex, endIndex + 1));
                        reverse.reverse();
                        System.out.println(reverse);
                    }
                    break;
                case "Substring":
                    if (username.contains(command[1])) {
                        int index = username.indexOf(command[1]);
                        StringBuilder substring = new StringBuilder(username);
                        substring.delete(index, index + command[1].length());
                        System.out.println(substring);
                    } else {
                        System.out.println("The username " + username + " doesn't contain " + command[1]);
                    }
                    break;
                case "Replace":
                    username = username.replaceAll(command[1], "-");
                    System.out.println(username);
                    break;
                case "IsValid":
                    if (username.contains(command[1])){
                        System.out.println("Valid username.");
                    } else {
                        System.out.println(command[1] + " must be contained in your username.");
                    }
            }
        }

    }
}
