package Methods_Exercise;

import java.util.Scanner;

public class PasswordValidator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (!checkSymbol(password).equals("true"))
            System.out.println(checkSymbol(password));

        if (!checkLetterAndDigit(password).equals("true"))
            System.out.println(checkLetterAndDigit(password));

        if (!checkDigit(password).equals("true"))
            System.out.println(checkDigit(password));


        if (checkSymbol(password).equals("true") && checkDigit(password).equals("true") && checkLetterAndDigit(password).equals("true"))
            System.out.println("Password is valid");

    }

    public static String checkSymbol(String password) {
        if (password.length() < 6 || password.length() > 10) {
            return "Password must be between 6 and 10 characters";
        }
        return "true";
    }

    public static String checkDigit(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) > 47 && password.charAt(i) < 58)
                count++;
        }
        if (count < 2)
            return "Password must have at least 2 digits";
        return "true";
    }

    public static String checkLetterAndDigit(String password) {
        boolean isRight = true;
        for (int i = 0; i < password.length(); i++) {
            if (!((password.charAt(i) > 47 && password.charAt(i) < 58)
                    || (password.charAt(i) > 64 && password.charAt(i) < 91)
                    || (password.charAt(i) > 96 && password.charAt(i) < 123)))
                isRight = false;
            if (!isRight)
                return "Password must consist only of letters and digits";
        }
        return "true";
    }
}
