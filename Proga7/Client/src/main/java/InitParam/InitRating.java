package InitParam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitRating {
    public static String initializeMpaaRating(){
        System.out.print("Enter the MPAA rating of movie ( PG, PG 13, R ): ");
        Scanner scanner = new Scanner(System.in);
        String mpaaRaiting = scanner.nextLine().trim();
        if (mpaaRaiting.toLowerCase().equals("PG".toLowerCase())){
            return "PG".toUpperCase();
        }
        if (mpaaRaiting.toLowerCase().equals("PG13".toLowerCase())){
            return "PG13".toUpperCase();
        }
        if (mpaaRaiting.toLowerCase().equals("R".toLowerCase())){
            return "R".toUpperCase();
        }
        System.out.print("The MPAA rating of movie is entered incorrectly. Do you want to fix it? (yes/no)");
        String answer = scanner.nextLine().trim();
        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initializeMpaaRating();
        }
        return "Invaluable".toUpperCase();
    }
}
