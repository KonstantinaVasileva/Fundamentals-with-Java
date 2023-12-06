package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfTheGroup = scanner.nextLine();
        String dayOfTheWeek = scanner.nextLine();
        double price = 0;

        switch (typeOfTheGroup) {
            case "Students":
                switch (dayOfTheWeek){
                    case "Friday":
                        price = groupOfPeople * 8.45;
                        break;
                    case "Saturday":
                        price = groupOfPeople * 9.8;
                        break;
                    case "Sunday":
                        price = groupOfPeople * 10.46;
                        break;
                }
                if (groupOfPeople >= 30)
                    price *= .85;
                break;
            case "Business":
                if (groupOfPeople >= 100)
                    groupOfPeople -= 10;
                switch (dayOfTheWeek){
                    case "Friday":
                        price = groupOfPeople * 10.9;
                        break;
                    case "Saturday":
                        price = groupOfPeople * 15.6;
                        break;
                    case "Sunday":
                        price = groupOfPeople * 16;
                        break;
                }
                break;
            case "Regular":
                switch (dayOfTheWeek){
                    case "Friday":
                        price = groupOfPeople * 15;
                        break;
                    case "Saturday":
                        price = groupOfPeople * 20;
                        break;
                    case "Sunday":
                        price = groupOfPeople * 22.50;
                        break;
                }
                if (groupOfPeople >= 10 && groupOfPeople <= 20)
                    price *= 0.95;
                break;

        }
        System.out.printf("Total price: %.2f", price);

    }
}
