package MapsLambdaAndStreamAPI_Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Double, Integer> count = new TreeMap<>();
        double[] numbers =Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double number:numbers){
            if (count.containsKey(number)){
                count.put(number, count.get(number) + 1);
            } else {
                count.put(number, 1);
            }
        }
        for (Map.Entry<Double, Integer> entry:count.entrySet()){
            DecimalFormat df = new DecimalFormat("#.######");
            System.out.printf("%S -> %d\n", df.format(entry.getKey()), entry.getValue());
        }

    }
}
