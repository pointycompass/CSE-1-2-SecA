package bytestream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

class FileCopyDemo {
    public static void main(String args[]) throws Exception {
        String source = "files/src.mp4";
        String destination = "files/copy.mp4";
        InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(destination);

        /*while (true) {
            int c = in.read();
            if (c == -1) break;
            out.write(c);
        }*/

        byte[] b = new byte[1024];
        int chunks = in.available() / b.length;
        for (int i = 0; i < chunks; i++) {
            in.read(b);
            out.write(b);
        }
        b = new byte[in.available()];
        in.read(b);
        out.write(b);

        in.close();
        out.close();
    }
}
