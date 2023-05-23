package InitParam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitMovieName {
    public static String initializeNameOfMovie(){
        System.out.print("Название фильма: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Pattern patern = Pattern.compile("^([A-z0-9]{1,}|[А-я0-9]{1,} [А-я0-9]{1,}|[А-я0-9]{1,}_[А-я0-9]{2,}|[A-z0-9]{1,} [A-z0-9]{1,}|[А-я0-9]{1,})$");
        Matcher mat = patern.matcher(name);
        if (mat.matches()){
            return name;
        }
        System.out.print("Введенное значения некорректно. Желаете ли вы исправить? (да/нет) ");
        String answer = scanner.nextLine().trim();
        Pattern pattern_2 = Pattern.compile("(Да|ДА|да)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initializeNameOfMovie();
        }
        return "Unknown";
    }
}
