public class EnumDemo2 {
    public static void main(String args[]) {
        Apple ap;
        System.out.println("Here are all Apple constants:");
        // use values()
        Apple allApples[] = Apple.values();
        for (Apple a : allApples) {
            System.out.println(a);
        }
        System.out.println();
        // use valueOf()
        ap = Apple.valueOf("GoldenDel");
        System.out.println("ap contains " + ap);
    }
}

