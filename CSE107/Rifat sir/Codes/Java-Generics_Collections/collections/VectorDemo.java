package collections;

import java.util.Vector;

class VectorDemo {

    public static void main(String args[]) {
        Vector<Integer> v = new Vector<>();
        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " + v.capacity());
        v.addElement(1);
        v.addElement(2);
        v.addElement(3);
        v.addElement(4);
        v.addElement(5);
        System.out.println("First element: " + v.firstElement());
        System.out.println("Last element: " + v.lastElement());

        if (v.contains(3)) System.out.println("Vector contains 3.");
        v.remove(4);

        // iterate
        for (int i = 0; i < v.size(); i++) {
            Integer a = v.elementAt(i);
            System.out.println(a);
        }
    }
}
