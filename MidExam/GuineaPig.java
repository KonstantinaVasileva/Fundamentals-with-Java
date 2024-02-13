package MidExam;

import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double food = Double.parseDouble(scanner.nextLine());
        double hay = Double.parseDouble(scanner.nextLine());
        double cover = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());

        for (int day = 1; day < 31; day++) {
           // weight += 0.3;
            food -= 0.3;
            if (day % 2 == 0)
                hay -= food * 0.05;
            if (day % 3 == 0)
                cover -= weight / 3;
            if (food <= 0 || hay <= 0 || cover <= 0){
                System.out.println("Merry must go to the pet store!");
                return;
            }
        }
        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", food, hay, cover);

    }
}
