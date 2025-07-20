package tcpforward;

import util.SocketWrapper;

import java.io.IOException;
import java.util.HashMap;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private SocketWrapper socketWrapper;
    public HashMap<String, SocketWrapper> clientMap;

    public ReadThreadServer(HashMap<String, SocketWrapper> map, SocketWrapper socketWrapper) {
        this.clientMap = map;
        this.socketWrapper = socketWrapper;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = socketWrapper.read();
                if (o instanceof Message) {
                    Message obj = (Message) o;
                    String to = obj.getTo();
                    SocketWrapper nu = (SocketWrapper) clientMap.get(to);
                    if (nu != null) {
                        nu.write(obj);
                    }
                }
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
