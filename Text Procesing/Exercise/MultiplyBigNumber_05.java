package TextProcessing.Exercise;

import java.util.Scanner;

public class MultiplyBigNumber_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstNumber = scanner.nextLine();
        int digit = Integer.parseInt(scanner.nextLine());

        StringBuilder product = new StringBuilder();
        int remainder = 0;

        for (int i = firstNumber.length() - 1; i >= 0; i--) {
            int currentDigit = Integer.parseInt(String.valueOf(firstNumber.charAt(i)));
            currentDigit = (currentDigit * digit) + remainder;
            product.append(currentDigit % 10);
            remainder = currentDigit / 10;
        }
        if (remainder != 0) {
            product.append(remainder);
        }

        // product.reverse();
        boolean zero = true;
        for (int i = 0; i < product.length(); i++) {
            if (Integer.parseInt(product.substring(i, i + 1)) != 0) {
                zero = false;
            }
        }
        if (zero) {
            System.out.println(0);
        } else {
            StringBuilder output = new StringBuilder();
            boolean trailing = true;
            for (int i = product.length() - 1; i >= 0; i--) {
                if (Integer.parseInt(product.substring(i, i + 1)) == 0 && trailing) {

                } else {
                    trailing = false;
                    output.append(product.charAt(i));
                }
            }
            System.out.println(output);
        }

        //  System.out.println(product);

    }
}
