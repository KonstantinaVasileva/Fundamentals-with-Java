package TextProcessing.Lab;

import java.util.Scanner;

public class ReverseStrings_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String text = scanner.nextLine();
            if (text.equals("end")){
                break;
            }
            String result = text + " = ";
            System.out.println(result + new StringBuilder(text).reverse());
        }

    }
}
