package tcpforward;

import util.SocketWrapper;

import java.util.Scanner;

public class Client {

    public Client(String serverAddress, int serverPort) {
        Scanner scanner = null;
        try {
            System.out.print("Enter name of the client: ");
            scanner = new Scanner(System.in);
            String clientName = scanner.nextLine();
            SocketWrapper socketWrapper = new SocketWrapper(serverAddress, serverPort);
            socketWrapper.write(clientName);
            new ReadThreadClient(socketWrapper);
            new WriteThreadClient(socketWrapper, clientName);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            scanner.close();
        }
    }

    public static void main(String args[]) {
        String serverAddress = "127.0.0.1";
        int serverPort = 44444;
        new Client(serverAddress, serverPort);
    }
}
