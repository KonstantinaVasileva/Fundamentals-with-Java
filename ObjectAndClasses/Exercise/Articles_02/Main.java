package ObjectsAndClasses_Exercises.Articles_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] articleData = scanner.nextLine().split(", ");
        String title = articleData[0];
        String content = articleData[1];
        String author = articleData[2];
        int number = Integer.parseInt(scanner.nextLine());
        Articles article = new Articles(title, content, author);

        for (int i = 1; i <= number; i++) {
            String[] command = scanner.nextLine().split(": ");
            switch (command[0]) {
                case "Edit":
                    article.edit(command[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(command[1]);
                    break;
                case "Rename":
                    article.rename(command[1]);
            }
        }
        System.out.println(article);

    }
}
