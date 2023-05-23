package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class MakeConnection{
    private static String userName;
    private static String password;
    private static final String connectionUrl = "jdbc:postgresql://localhost:5432/studs";
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void maKeAdatabaseConnection() throws ClassNotFoundException {
        MakeConnection makeConnection = new MakeConnection();
        makeConnection.setUserName("Введите имя пользователя: ");
        makeConnection.setPassword("Введите пароль: ");
        Class.forName("org.postgresql.Driver");
        try{
            Connection connect = DriverManager.getConnection(connectionUrl, userName, password);
            System.out.println("База данных подключена");
            connection =  connect;
            statement = connection.createStatement();
        }catch (Exception e){
            System.out.println("Неправильное имя или пароль. Пожалуйста, повторите...");
            maKeAdatabaseConnection();
        }
    }
    private void setUserName(String str) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(str);
        String userName = scanner.nextLine();
        this.userName = userName;
    }

    private void setPassword(String str) {
        Scanner scanner_2 = new Scanner(System.in);
        System.out.print(str);
        String password = scanner_2.nextLine();
        this.password = password;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static Statement getStatement() {
        return statement;
    }
}
