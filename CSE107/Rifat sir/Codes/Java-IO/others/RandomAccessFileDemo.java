package others;

import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("random.txt", "rw");
        // write something in the file
        file.write("Hello".getBytes());
        System.out.println(file.getFilePointer());
        // set the file pointer at 0 position
        file.seek(0);
        System.out.println(file.getFilePointer());
        // print the line
        System.out.println(file.readLine());
        // set the file pointer at 10 position
        file.seek(10);
        // write something in the file
        file.write("World".getBytes());
        // set the file pointer at 0 position
        file.seek(0);
        // print the line
        System.out.println(file.readLine());
        file.close();
    }
}
