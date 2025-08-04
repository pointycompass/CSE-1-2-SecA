public class WrapDemo {
    public static void main(String args[]) {
        Integer iOb = new Integer(100); //boxing
        int i = iOb.intValue(); // unboxing
        Integer iObNew = 200; // auto-boxing
        int inew = iObNew; // autounboxing
        System.out.println(i + " " + iOb);
        System.out.println(inew + " " + iObNew);
    }
}