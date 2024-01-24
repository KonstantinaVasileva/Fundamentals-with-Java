package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class ListOfProducts_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        List<String> products = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            products.add(scanner.nextLine());
        }

        Collections.sort(products);
        int num = 1;
        for (String name:products) {
            System.out.printf("%d.%s\n", num, name);
            num ++;
        }

    }
}
