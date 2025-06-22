public class StringSplitTest {
    public static void main(String[] args) {
        String test = "abc,,def,123";
        String[] out = test.split(",");
        System.out.println(out.length);
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }

        // String.split() does produce empty tokens, but StringTokenizer doesn't
        
        String t = new String("abc,,def,123");
        java.util.StringTokenizer tokens = new java.util.StringTokenizer(t, ",");
        System.out.println(tokens.countTokens());
        while (tokens.hasMoreTokens()) {
            System.out.println(tokens.nextToken());
        }
        
    }
}
