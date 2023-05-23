package Server;

import Launcher.Launcher;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    private Socket client;
    private ObjectOutputStream writer;
    private ObjectInputStream reader;

    public ClientHandler(Socket socket, ObjectOutputStream oos, ObjectInputStream ois){
        this.client = socket;
        this.writer = oos;
        this.reader = ois;
    }

    @Override
    public void run(){
        System.out.println("New thread " + Thread.currentThread().getName() + " is started.");
        while (true){
            try {
                ArrayList<ArrayList<String>> list = (ArrayList<ArrayList<String>>) reader.readObject();
                writer.writeObject(Launcher.launcher(list));
            } catch (IOException e) {
            } catch (ClassNotFoundException e) {
            } catch (SQLException e) {
            }
        }
    }
}




