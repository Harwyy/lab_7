package Authorization;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String name;
    private String password;

    public ArrayList<ArrayList<String>> logIn(){
        ArrayList<String> miniList = new ArrayList<>();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        System.out.println("Если вы желаете зарегистрироваться, нажмите 0...");
        System.out.println("Если вы желаете авторизоваться, нажмите 1...");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("0")){
            miniList.add("registration");
            this.name = enterName();
            miniList.add(name);
            this.password = createPassword();
            miniList.add(password);
            list.add(miniList);
            return list;
        } else if (answer.equals("1")) {
            miniList.add("authorization");
            this.name = enterName();
            miniList.add(name);
            this.password = enterPassword();
            miniList.add(password);
            list.add(miniList);
            return list;
        } else {
            System.out.println("Не пробил. Попробуй ещё...");
            return logIn();
        }
    }

    private static String enterName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        if (name.length() >= 24){
            System.out.println("Пожалуйста, введите имя, не превышающее 23 символов.");
            return enterName();
        }
        return name;
    }

    private static String createPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Придумайте пароль: ");
        String password_1 = scanner.nextLine();
        System.out.print("Повторите пароль: ");
        String password_2 = scanner.nextLine();
        if (password_1.equals(password_2)){
            return MD2.encryptThisString(password_1);
        } else {
            System.out.println("Пароли не совпадают, попробуйте заново...");
            return createPassword();
        }
    }

    private static String enterPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваш пароль: ");
        String password = scanner.nextLine();
        return MD2.encryptThisString(password);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
