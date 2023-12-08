package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class PokeMon_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int tempPower = pokePower;

        while (tempPower>=distance){
            tempPower -=distance;
            count++;
            if (pokePower / 2 == tempPower && exhaustionFactor!=0)
                tempPower /= exhaustionFactor;
        }
        System.out.println(tempPower);
        System.out.println(count);

    }
}
