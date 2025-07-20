package tcpstring;

import util.SocketWrapper;

import java.io.IOException;

public class ReadThread implements Runnable {
    private Thread thr;
    private SocketWrapper socketWrapper;

    public ReadThread(SocketWrapper socketWrapper) {
        this.socketWrapper = socketWrapper;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                String s = (String) socketWrapper.read();
                System.out.println("Received: " + s);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                socketWrapper.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
