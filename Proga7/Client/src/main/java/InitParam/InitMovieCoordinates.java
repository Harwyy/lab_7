package InitParam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitMovieCoordinates {
    public static Integer initializeCoordinateX(){
        System.out.print("Введите X: ");
        Scanner scanner = new Scanner(System.in);
        String X = scanner.nextLine().trim();
        Pattern pattern = Pattern.compile("(\\d{1,8})");
        Matcher mt = pattern.matcher(X);
        if (mt.matches()){
            return Integer.parseInt(X);
        }
        System.out.print("Введённая координата X некорректна. Желаете ли вы исправить? (да/нет) ");
        String answer = scanner.nextLine().trim();
        Pattern pattern_2 = Pattern.compile("(Да|да|ДА)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initializeCoordinateX();
        }
        return 0;
    }
    public static Double initializeCoordinateY(){
        System.out.print("Введите Y: ");
        Scanner scanner = new Scanner(System.in);
        String Y = scanner.nextLine().trim();
        Pattern pattern = Pattern.compile("(\\d{1,}|\\d{1,}\\.\\d{1,})");
        Matcher mt = pattern.matcher(Y);
        if (mt.matches()){
            return Double.parseDouble(Y);
        }
        System.out.print("Введённая координата Y некорректна. Желаете ли вы исправить? (да/нет) ");
        String answer = scanner.nextLine().trim();
        Pattern pattern_2 = Pattern.compile("(Да|да|ДА)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initializeCoordinateY();
        }
        return 0d;
    }
}
