public class StringTest {
    public static void main(String[] args) {
        String s = "Hello World";
        char [] c = new char[5];
        s.getChars(0, 5, c, 0);
        System.out.println(c);
        String t = "Hello";
        System.out.println(s.regionMatches(true, 0, t, 0, 5));
    }
}
