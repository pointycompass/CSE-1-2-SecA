package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramClient implements Runnable {

    DatagramClient() {
        new Thread(this).start();
    }

    public void run() {
        while (true) {
            try {
                receive();
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void receive() throws Exception {
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        DatagramSocket socket = new DatagramSocket(8000);
        socket.receive(packet);
        String str = new String(packet.getData(), 0, packet.getLength());
        System.out.println(str);
        socket.close();
    }

    public static void main(String[] args) {
        new DatagramClient();
    }
}
