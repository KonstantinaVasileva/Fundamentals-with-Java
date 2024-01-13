package Methods_Exercise;

import java.util.Scanner;

public class PalindromeIntegers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")){

            System.out.println(palindrome(input));

            input = scanner.nextLine();
        }

    }

    public static boolean palindrome (String num){
        boolean isPalindrome = true;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != num.charAt(num.length()-1-i))
                isPalindrome = false;
        }
        return isPalindrome;
    }
}
