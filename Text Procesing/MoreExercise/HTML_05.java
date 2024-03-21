package TextProcessing.More_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HTML_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String content = scanner.nextLine();

        List<String> comments = new ArrayList<>();

        while (true){
            String comment = scanner.nextLine();
            if (comment.equals("end of comments")){
                break;
            }
            comments.add(comment);
        }

        System.out.println("<h1>\n\t" + title + "\n</h1>");
        System.out.println("<article>\n\t" + content + "\n</article>");
        System.out.printf("<div>\n\t%s\n</div>", String.join("\n</div>\n<div>\n\t", comments));

    }
}
