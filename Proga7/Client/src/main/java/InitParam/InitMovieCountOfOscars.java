package InitParam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitMovieCountOfOscars {
    public static Long initializeOscarsCount(){
        System.out.print("Количество полученных оскаров: ");
        Scanner scanner = new Scanner(System.in);
        String oscarsCount = scanner.nextLine().trim();
        Pattern pattern = Pattern.compile("\\d{1,5}");
        Matcher mt = pattern.matcher(oscarsCount);
        if (mt.matches()){
            return Long.parseLong(oscarsCount);
        }
        System.out.print("Введённое количество оскаров некорректно. Желаете ли вы исправить? (да/нет) ");
        String answer = scanner.nextLine().trim();
        Pattern pattern_2 = Pattern.compile("(ДА|Да|да)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initializeOscarsCount();
        }
        return 0L;
    }
}
