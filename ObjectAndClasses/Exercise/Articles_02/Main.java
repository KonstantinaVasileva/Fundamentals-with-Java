package ObjectsAndClasses_Exercises.AdvertisementMessage_01;

import ObjectsAndClasses_Exercises.AdvertisementMessage_01.Message;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Message message = new Message();

        for (int i = 1; i <= number; i++) {
            System.out.println(message.randomMessage());
        }
    }
}
