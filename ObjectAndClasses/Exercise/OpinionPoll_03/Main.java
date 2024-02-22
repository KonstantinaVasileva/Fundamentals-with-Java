package ObjectsAndClasses_Exercises.OpinionPoll_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= number; i++) {
            String[] personInfo = scanner.nextLine().split(" ");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            Person person = new Person(name, age);
            if (person.getAge() > 30){
                System.out.printf("%s - %d\n", person.getName(), person.getAge());
            }
        }

    }
}
