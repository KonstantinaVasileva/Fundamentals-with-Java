package Methods;

import java.util.Scanner;

public class Orders_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        totalPrice(product, quantity);

    }

    public static void totalPrice(String product, int quantity) {
        double total = 0;
        switch (product) {
            case "coffee":
                total = 1.5 * quantity;
                break;
            case "water":
                total = 1.0 * quantity;
                break;
            case "coke":
                total = 1.4 * quantity;
                break;
            case "snacks":
                total = 2.0 * quantity;
                break;
        }
        System.out.printf("%.2f", total);
    }
}
