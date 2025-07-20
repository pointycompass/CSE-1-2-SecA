package tcpforward;

import util.SocketWrapper;

import java.io.IOException;
import java.util.Scanner;

public class WriteThreadClient implements Runnable {

    private Thread thr;
    private SocketWrapper socketWrapper;
    String name;

    public WriteThreadClient(SocketWrapper socketWrapper, String name) {
        this.socketWrapper = socketWrapper;
        this.name = name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        Scanner input = null;
        try {
            input = new Scanner(System.in);
            while (true) {
                String from = name;
                System.out.print("Enter name of the client to send: ");
                String to = input.nextLine();
                System.out.print("Enter the message: ");
                String text = input.nextLine();
                Message message = new Message();
                message.setFrom(from);
                message.setTo(to);
                message.setText(text);
                socketWrapper.write(message);
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
