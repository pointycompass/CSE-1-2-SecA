package tcpobject;

import util.SocketWrapper;

public class Client {

    public Client(String serverAddress, int serverPort) {
        try {
            SocketWrapper socketWrapper = new SocketWrapper(serverAddress, serverPort);
            new ReadThread(socketWrapper);
            new WriteThread(socketWrapper, "Client");
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
