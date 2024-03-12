package TextProcessing.Exercise;

import java.util.Scanner;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (int i = 0; i < usernames.length; i++) {
            boolean isValid = true;
            String currentUsername = usernames[i];
            if (currentUsername.length() < 3 || currentUsername.length() > 16){
                continue;
            }
            for (int j = 0; j < currentUsername.length(); j++) {
                char ch = currentUsername.charAt(j);
                if (!Character.isLetter(ch) && !Character.isDigit(ch) && ch != '-' && ch != '_'){
                    isValid = false;
                    break;
                }
            }
            if (isValid){
                System.out.println(currentUsername);
            }
        }

    }
}
