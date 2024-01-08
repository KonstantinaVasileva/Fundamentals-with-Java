package Arrays_More_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Encrypt_Sort_And_Print_Array_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int[] encrypt = new int[number];
        for (int i = 0; i < number; i++) {
            String name = scanner.nextLine();
            int sum = 0;
            for (int j = 0; j < name.length(); j++) {


                if (name.charAt(j) == ('A') || name.charAt(j) == ('a') || name.charAt(j) == ('O') || name.charAt(j) == ('o')
                        || name.charAt(j) == ('U') || name.charAt(j) == ('u') || name.charAt(j) == ('E') || name.charAt(j) == ('e')
                        || name.charAt(j) == ('I') || name.charAt(j) == ('i'))
                    sum += name.charAt(j) * name.length();
                else sum = sum + name.charAt(j) / name.length();
            }
            encrypt[i] = sum;
        }
        Arrays.sort(encrypt);
        for (int num : encrypt) System.out.println(num);
    }
}
