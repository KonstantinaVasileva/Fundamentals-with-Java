package MidExam;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfCustomer = scanner.nextLine();
        double sum = 0;

        while (!(typeOfCustomer.equals("special") || typeOfCustomer.equals("regular"))){
            double price = Double.parseDouble(typeOfCustomer);
            if (price <= 0) {
                System.out.println("Invalid price!" );
                typeOfCustomer = scanner.nextLine();
                continue;
            }
            sum += price;
            typeOfCustomer = scanner.nextLine();
        }
        if (sum == 0){
            System.out.println("Invalid order!");
            return;
        }
        double taxes =sum * .2;
        double totalPrice = sum + taxes;
        if (typeOfCustomer.equals("special")){
            totalPrice *= 0.9;
        }

        System.out.printf("Congratulations you've just bought a new computer!\nPrice without taxes: %.2f$\n" +
                "Taxes: %.2f$ \n" +
                        "-----------\n" +
                "Total price: %.2f$", sum, taxes, totalPrice);

    }
}
