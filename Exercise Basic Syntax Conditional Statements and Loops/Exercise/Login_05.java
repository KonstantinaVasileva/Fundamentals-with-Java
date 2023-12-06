package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class Login_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
      //  String password = scanner.nextLine();

        StringBuffer rightPassword = new StringBuffer();
        rightPassword.append(username);
        rightPassword.reverse();

        for (int i = 0; i < 4; i++) {
            String password = scanner.nextLine();
            if (password.equals(rightPassword.toString())) {
                System.out.printf("User %s logged in.", username);
                break;
            }
            if (i == 3){
                System.out.printf("User %s blocked!", username );
            break;}
            System.out.println("Incorrect password. Try again.");
        }


    }
}
