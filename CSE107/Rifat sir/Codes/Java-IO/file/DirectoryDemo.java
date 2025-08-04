package file;
import java.io.File;

class DirectoryDemo {

    public static void visitDir(File f) {
        if (f.isDirectory()) {
            File s[] = f.listFiles();
            for (int i = 0; i < s.length; i++) {
                System.out.println(s[i]);
                if (s[i].isDirectory()) {
                    visitDir(s[i]);
                }
            }
        }
    }

    public static void main(String args[]) {
        String dirname = "files/dir";
        File f = new File(dirname);
        visitDir(f);
    }
}
