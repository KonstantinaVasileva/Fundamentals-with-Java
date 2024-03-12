package TextProcessing.Exercise;

import java.util.Scanner;

public class ExtractFile_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        int index = path.lastIndexOf("\\");
        String[] fileNameExt = path.substring(index + 1).split("\\.");

        System.out.println("File name: " + fileNameExt[0]);
        System.out.println("File extension: " + fileNameExt[1]);

    }
}
