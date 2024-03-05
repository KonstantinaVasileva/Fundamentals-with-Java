package MapsLambdaAndStreamAPI_Exercise;

import java.util.*;

public class Orders_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Double> productQuantity = new LinkedHashMap<>();
        LinkedHashMap<String, Double> productPrice = new LinkedHashMap<>();

        while (true) {
            String[] productInfo = scanner.nextLine().split(" ");
            if (productInfo[0].equals("buy")) {
                break;
            }
            String product = productInfo[0];
            double price = Double.parseDouble(productInfo[1]);
            double quantity = Double.parseDouble(productInfo[2]);

            productQuantity.putIfAbsent(product, (double) 0);
            productQuantity.put(product, productQuantity.get(product) + quantity);
            productPrice.put(product, price);
        }
        for (Map.Entry<String, Double> entry : productPrice.entrySet()) {
            System.out.printf("%s -> %.2f\n", entry.getKey(), entry.getValue() * productQuantity.get(entry.getKey()));
        }

    }
}
