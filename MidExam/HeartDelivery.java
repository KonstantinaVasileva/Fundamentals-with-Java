package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] neighborhood = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        int currentPlace = 0;
        int failedPlace = neighborhood.length;

         while (!command.equals("Love!")){
             int jump = Integer.parseInt(command.split(" ")[1]);
             currentPlace += jump;
             if (currentPlace >= neighborhood.length)
                 currentPlace = 0;
             if (neighborhood[currentPlace] == 0){
                 System.out.printf("Place %d already had Valentine's day.\n", currentPlace);
             } else {
                 neighborhood[currentPlace] -= 2;
                 if (neighborhood[currentPlace] <= 0) {
                     neighborhood[currentPlace] = 0;
                     System.out.printf("Place %d has Valentine's day.\n", currentPlace);
                     failedPlace -= 1;
                 }
             }

             command = scanner.nextLine();
         }
        System.out.printf("Cupid's last position was %d.\n", currentPlace);
         if (failedPlace == 0){
             System.out.println("Mission was successful.");
         } else System.out.printf("Cupid has failed %d places.", failedPlace);

    }
}
