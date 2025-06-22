import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) {
        String s = new String("what’s your news");
        StringTokenizer tokens = new StringTokenizer(s);
        System.out.println(tokens.countTokens());
        while (tokens.hasMoreTokens()) {
            System.out.println(tokens.nextToken());
        }

        String t = new String("what’s,your,news");
        tokens = new StringTokenizer(t, ",");
        System.out.println(tokens.countTokens());
        while (tokens.hasMoreTokens()) {
            System.out.println(tokens.nextToken());
        }
    }
}
