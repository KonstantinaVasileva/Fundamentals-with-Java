package BasicSyntaxConditionalStatementsAndLoopMoreExerrcise;

import java.util.Scanner;

public class ReverseString_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuffer text = new StringBuffer(scanner.nextLine());
        text.reverse();
        System.out.print(text);

    }
}
