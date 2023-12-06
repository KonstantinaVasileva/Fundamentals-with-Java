package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class PadawanEquipment_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amountOfMoney = Double.parseDouble(scanner.nextLine());
        int countOfStudent = Integer.parseInt(scanner.nextLine());
        double priceOfLightsabers = Double.parseDouble(scanner.nextLine());
        double priceOfRobes = Double.parseDouble(scanner.nextLine());
        double priceOfBelts = Double.parseDouble(scanner.nextLine());

        double totalPriceOfLightsabers = Math.ceil(countOfStudent * 1.1) * priceOfLightsabers;
        double totalPriceOfRobes = countOfStudent * priceOfRobes;
        double totalPriceOfBelts = (countOfStudent - countOfStudent/6) * priceOfBelts;

        double totalPrice = totalPriceOfLightsabers + totalPriceOfRobes + totalPriceOfBelts;

        if (totalPrice <= amountOfMoney)
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        else System.out.printf("George Lucas will need %.2flv more.", totalPrice - amountOfMoney);

    }
}
