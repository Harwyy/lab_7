package InitParam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitMovieGenre {
    public static String initializeMovieGenre() {
        System.out.print("Жанр ( Western, Drama, Tragedy, Fantasy ): ");
        Scanner scanner = new Scanner(System.in);
        String movieGenre = scanner.nextLine().trim();
        if (movieGenre.toLowerCase().equals("Western".toLowerCase())) {
            return "Western".toUpperCase();
        }
        if (movieGenre.toLowerCase().equals("Drama".toLowerCase())) {
            return "Drama".toUpperCase();
        }
        if (movieGenre.toLowerCase().equals("Tragedy".toLowerCase())) {
            return "Tragedy".toUpperCase();
        }
        if (movieGenre.toLowerCase().equals("Fantasy".toLowerCase())) {
            return "Fantasy".toUpperCase();
        }
        System.out.print("Введённый жанр некорректный. Желаете ли вы исправить? (да/нет)");
        String answer = scanner.nextLine().trim();
        Pattern pattern_2 = Pattern.compile("(ДА|Да|да)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()) {
            return initializeMovieGenre();
        }
        return "Unidentified".toUpperCase();
    }
}
