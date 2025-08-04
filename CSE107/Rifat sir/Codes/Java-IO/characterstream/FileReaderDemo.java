package characterstream;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

class FileReaderDemo {
    public static void main(String args[]) throws Exception {
        File f = new File("files/TestFile.txt");
        Reader fr = new FileReader(f);
        char data[] = new char[(int) f.length()];
        fr.read(data);
        System.out.println(new String(data));
        fr.close();
    }
}