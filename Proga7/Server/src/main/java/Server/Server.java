package Server;

import Launcher.Launcher;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Server {

    public static final  int DEFAULT_PORT = 8081;

    private final int port_number;

    public int getPort_number(){
        return port_number;
    }

    public Server(){
        this.port_number = DEFAULT_PORT;
    }

    public Server(int port_number){
        this.port_number = port_number;
    }

    public void startServer(){
        try {
            final ServerSocket server = new ServerSocket(this.port_number);
            System.out.println("Сервер прослушивает порт: " + this.port_number);
            while (true){
                Socket s = server.accept();
                ObjectOutputStream writer = new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream reader = new ObjectInputStream(s.getInputStream());
                Thread thread = new Thread(new ClientHandler(s, writer, reader));
                thread.start();
            }
        } catch (IOException ex){
            System.out.println("KKK");
            System.out.println(ex.getMessage());
        }
    }
}
