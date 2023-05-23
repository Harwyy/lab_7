package InitParam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitOperator {
    public static String initializeName(){
        System.out.print("Имя режиссёра: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().trim();
        Pattern patern = Pattern.compile("^([A-z]{2,}|[А-я]{2,} [А-я]{2,}|[А-я]{2,}_[А-я]{2,}|[A-z]{2,} [A-z]{2,}|[А-я]{2,})$");
        Matcher mat = patern.matcher(name);
        if (mat.matches()){
            return name;
        }
        System.out.print("Введённое имя некорректно. Желаете ли вы исправить? (да/нет) ");
        String answer = scanner.nextLine().trim();
        answer = answer.replaceAll(" ", "");
        Pattern pattern_2 = Pattern.compile("(Да|да|ДА)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initializeName();
        }
        return "Unknown";
    }
    public static Integer initializeWeight(){
        System.out.print("Вес режиссёра: ");
        Scanner scanner = new Scanner(System.in);
        String weight = scanner.nextLine().trim();
        weight = weight.replaceAll(" ", "");
        Pattern pattern = Pattern.compile("(\\d{1,4})");
        Matcher mt = pattern.matcher(weight);
        if (mt.matches()){
            return Integer.parseInt(weight);
        }
        System.out.print("Введённый вес некорректный. Желаете ли вы исправить? (да/нет) ");
        String answer = scanner.nextLine().trim();
        answer = answer.replaceAll(" ", "");
        Pattern pattern_2 = Pattern.compile("(Да|да|ДА)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initializeWeight();
        }
        return 75;
    }
    public static String initializeHairColor(){

        System.out.print("Цвет волос режиссёра ( Green, Blue, Orange, White, Brown ): ");
        Scanner scanner = new Scanner(System.in);
        String hairColor = scanner.nextLine().trim();
        if (hairColor.toLowerCase().equals("Green".toLowerCase())){
            return "Green".toUpperCase();
        }
        if (hairColor.toLowerCase().equals("Blue".toLowerCase())){
            return "Blue".toUpperCase();
        }
        if (hairColor.toLowerCase().equals("Orange".toLowerCase())){
            return "Orange".toUpperCase();
        }
        if (hairColor.toLowerCase().equals("White".toLowerCase())){
            return "White".toUpperCase();
        }
        if (hairColor.toLowerCase().equals("Brown".toLowerCase())){
            return "Brown".toUpperCase();
        }
        System.out.print("Введённый цвет волос некорректный. Желаете ли вы исправить? (да/нет) ");
        String answer = scanner.nextLine().trim();
        answer = answer.replaceAll(" ", "");
        Pattern pattern_2 = Pattern.compile("(Да|да|ДА)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initializeHairColor();
        }
        return "Unidentified".toUpperCase();
    }
    public static String initializeCountry(){
        System.out.print("Национальность режиссёра ( Spain, China, India ): ");
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine().trim();
        if (country.toLowerCase().equals("Spain".toLowerCase())){
            return "Spain".toUpperCase();
        }
        if (country.toLowerCase().equals("China".toLowerCase())){
            return "China".toUpperCase();
        }
        if (country.toLowerCase().equals("India".toLowerCase())){
            return "India".toUpperCase();
        }
        System.out.print("Введённая национальность режиссёра некорректна. Желаете ли вы исправить? (да/нет) ");
        String answer = scanner.nextLine().trim();
        Pattern pattern_2 = Pattern.compile("(Да|да|ДА)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initializeCountry();
        }
        return "Unidentified".toUpperCase();
    }
}
