public class Box {
    int L, W, H;

    Box(int l, int w, int h)
    {
        L = l;
        W = w;
        H = h;
    }

    public static void main(String[] args)
    {
        Box b1; // b1 refers to null
        Box b2; // b2 refers to null
        b1 = new Box(8, 5, 7); // b1 refers to new object (8, 5, 7)
        b2 = b1; // b2 refers to b1, so both refers (8, 5, 7)
        b1 = new Box(3, 9, 2); // b1 refers to new object (3, 9, 2)
        b1 = b2; // b1 refers to b2, what happens to object (3, 9, 2)

    }
}
