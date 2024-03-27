package RegularExpressions.MoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().trim().split("\\s*,\\s*");

        for (String ticket : tickets) {
            if (ticket.length() == 20) {
               // String regexJackpot = "@{20}|#{20}|\\${20}|\\^{20}";
               // Pattern patternJackpot = Pattern.compile(regexJackpot);
              //  Matcher matcher = patternJackpot.matcher(ticket);
                // String regex = ".{0,4}(?<winning>@{6,10}|#{6,10}|[$]{6,10}|\\^{6,10}).{0,8}\\1.{0,4}";
                // String regex = "(?=.{20}).*?(?=(?<ch>[@#$^]))(?<winning>\\k<ch>{6,}).*(?<=.{10})\\k<winning>.*";
                String regex = "@{6,10}|#{6,10}|[$]{6,10}|\\^{6,10}";
                Pattern pattern = Pattern.compile(regex);
                String leftPart = ticket.substring(0, 10);
                String rightPart = ticket.substring(10);
                Matcher matcherLeft = pattern.matcher(leftPart);
                Matcher matcherRight = pattern.matcher(rightPart);
                if (matcherLeft.find() && matcherRight.find()) {
                    if (matcherLeft.group().charAt(0) == matcherRight.group().charAt(0)
                    && matcherLeft.group().length() == matcherRight.group().length()) {
                        System.out.printf("ticket \"%s\" - %d%s%s%n",
                                ticket, matcherLeft.group().length(), matcherLeft.group().charAt(0),
                                (matcherLeft.group().length() == 10) ? " Jackpot!" : "");
                               // ticket, matcherLeft.group().length(), matcherLeft.group().charAt(0));
                       // System.out.printf("ticket \"%s\" - 10%s Jackpot!\n", ticket, matcher.group().charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - no match\n", ticket);
                    }
               /* } else if (matcherWin.find()) {
                    System.out.printf("ticket \"%s\" - %d%s",
                            ticket, matcherWin.group("winning").length(), matcherWin.group("winning").charAt(0));*/
                } else {
                    System.out.printf("ticket \"%s\" - no match\n", ticket);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }

    }
}
