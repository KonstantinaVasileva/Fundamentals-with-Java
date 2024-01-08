package Arrays_More_Exercise;


import java.util.Scanner;

public class RecursiveFibonacci_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int num1 = 1;
        int num2 = 1;
        int fibonacciNum = 1;
        for (int i = 2; i < number; i++) {
            fibonacciNum = num2 + num1;
            num1 = num2;
            num2 = fibonacciNum;
        }
        System.out.println(fibonacciNum);

    }
}
