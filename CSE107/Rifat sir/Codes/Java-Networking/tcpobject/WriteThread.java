package tcpobject;

import java.io.IOException;
import java.util.Scanner;

import util.SocketWrapper;

public class WriteThread implements Runnable {

    private Thread thr;
    private SocketWrapper socketWrapper;
    String name;

    public WriteThread(SocketWrapper socketWrapper, String name) {
        this.socketWrapper = socketWrapper;
        this.name = name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        Scanner input = null;
        try {
            int i = 1;
            input = new Scanner(System.in);
            while (true) {
                System.out.println("Enter a message to send: ");
                String s = input.nextLine();
                Data d = new Data();
                d.setId(i);
                d.setValue(s);
                socketWrapper.write(d);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                socketWrapper.closeConnection();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
