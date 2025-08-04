package characterstream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

class BufferedReaderDemo {
    public static void main(String args[]) throws Exception {
        Reader fr = new FileReader("files/TestFile.txt");
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String s = br.readLine();
            if (s == null) break;
            System.out.println(s);
        }
        br.close();
        fr.close();

    }
}