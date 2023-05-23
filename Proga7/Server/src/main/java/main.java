import DataBase.StartDB;
import Launcher.Launcher;
import Server.*;

import java.sql.SQLException;

public class main extends Thread{


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InterruptedException {
//        ssh -p 2222 sXXXXXX@se.ifmo.ru -L 5432:pg:5432
         String userName = "s368420";
         String password = "SGm3njJqt6YZ5Jmh";
        StartDB startDB = new StartDB();
        startDB.startDataBase();
        Launcher.readDataPro();
        Server server = new Server();
        server.startServer();
    }
}
