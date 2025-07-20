package tcpdiff;

import java.util.HashMap;
import java.util.Scanner;

import util.SocketWrapper;

public class WriteThreadServer implements Runnable {

    private Thread thr;
    String name;
    public HashMap<String, SocketWrapper> clientMap;

    public WriteThreadServer(HashMap<String, SocketWrapper> map, String name) {
        this.clientMap = map;
        this.name = name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        Scanner input = null;
        try {
            input = new Scanner(System.in);
            while (true) {
                System.out.println("Enter the name of the client to send, a message to send: ");
                String[] s = input.nextLine().split(",");
                SocketWrapper socketWrapper = (SocketWrapper) clientMap.get(s[0]);
                if (socketWrapper != null) {
                    socketWrapper.write(name + ":" + s[1]);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            input.close();
        }
    }
}
