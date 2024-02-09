package ListsMoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        List<String> symbol = new ArrayList<>();
        List<Integer> takeList = new ArrayList<>();
        List<Integer> hideList = new ArrayList<>();
        boolean isTake = true;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 48 && text.charAt(i) <= 57) {
                if (isTake) {
                    takeList.add(Integer.parseInt(String.valueOf(text.charAt(i))));
                    isTake = false;
                } else {
                    hideList.add(Integer.parseInt(String.valueOf(text.charAt(i))));
                    isTake = true;
                }
            } else {
                symbol.add(String.valueOf(text.charAt(i)));
            }
        }
        String message = "";
        for (int i = 0; i < takeList.size(); i++) {
            int index = takeList.get(i);
            if (index > symbol.size()) {
                index = symbol.size();
            }
            for (int j = 0; j < index; j++) {
                message += symbol.get(0);
                symbol.remove(0);
            }
            index = hideList.get(i);
            if (index > symbol.size()) {
                index = symbol.size();
            }
            for (int j = 0; j < index; j++) {
                symbol.remove(0);
            }
        }

        System.out.println(message);

    }
}
