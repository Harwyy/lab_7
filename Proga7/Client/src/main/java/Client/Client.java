package Client;

import Authorization.User;
import WorkWithCommand.Laucnher;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private Socket client;
    private ObjectOutputStream writer;
    private ObjectInputStream reader;
    private int PORT;

    public Client(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите порт: ");
        String PORT = scanner.nextLine();
        this.PORT = Integer.parseInt(PORT);
    }

    public void connect(){
        try{
            client = new Socket(InetAddress.getLocalHost(), PORT);
            reader = new ObjectInputStream(client.getInputStream());
            writer = new ObjectOutputStream(client.getOutputStream());
            System.out.println("Вы подключились к серверу на порту " + client.getPort());
            String helper = "";
            User user = new User();

            while (true){
                if (helper.equals("Новый пользователь создан. Приятной вам работы!") || helper.equals("Добро пожаловать на сервер!")){
                    break;
                }
                writer.writeObject(user.logIn());
                helper = (String) reader.readObject();
                System.out.println(helper);
            }
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.print("Введите команду(help): ");
                String text = scanner.nextLine().toLowerCase();
                ArrayList<ArrayList<String>> list = Laucnher.launcher(text, user);
                writer.writeObject(list);
                System.out.println((String) reader.readObject());
            }
        } catch (UnknownHostException e1){
            System.out.println("Неверный  порт...");
        } catch (IOException e2){
            System.out.println("В данный момент сервер отключен. Попробуйте попозже ...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect(){
        try{
            writer.close();
            reader.close();
            client.close();
        } catch (IOException ioException){

        }
    }

    public Socket getClient() {
        return client;
    }

    public ObjectOutputStream getWriter() {
        return writer;
    }

    public ObjectInputStream getReader() {
        return reader;
    }
}
