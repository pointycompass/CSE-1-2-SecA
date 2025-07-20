package tcpsimple;

import java.io.*;
import java.net.Socket;

public class Client {
    public Client(String serverAddress, int serverPort) {
        try {
            Socket socket = new Socket(serverAddress, serverPort);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String name = "C";
            oos.writeObject(name);
            System.out.println(ois.readObject());
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        String serverAddress = "127.0.0.1";
        int serverPort = 44444;
        new Client(serverAddress, serverPort);
    }
}
