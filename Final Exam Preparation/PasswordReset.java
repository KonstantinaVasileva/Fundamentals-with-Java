package FinalExam;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());

        while (true) {
            String[] command = scanner.nextLine().split("\\s");
            if (command[0].equals("Done")) {
                break;
            }
            switch (command[0]) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 == 1){
                            newPassword.append(password.charAt(i));
                        }
                    }
                    password = newPassword;
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    password.delete(index, index + length);
                    System.out.println(password);
                    break;
                case "Substitute":
                    if (password.indexOf(command[1]) == -1){
                        System.out.println("Nothing to replace!");
                    } else {
                        while (password.indexOf(command[1]) != -1){
                            int idx = password.indexOf(command[1]);
                            String substitute = command[2];
                            password.replace(idx, idx + command[1].length(), substitute);
                        }
                        System.out.println(password);
                    }
                    break;
            }
        }

        System.out.printf("Your password is: %s", password);
    }
}
