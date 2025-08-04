package collections;

import java.util.LinkedList;

class LinkedListDemo {
    public static void main(String args[]) {
        // create a linked list
        LinkedList<String> ll = new LinkedList<>();

        // add elements to the linked list
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("generics.Z");
        ll.addFirst("A");

        ll.add(1, "A2");

        System.out.println("Original contents of ll: " + ll);

        // remove elements from the linked list
        ll.remove("F");
        ll.remove(2);

        System.out.println("Contents of ll after deletion: " + ll);

        // remove first and last elements
        ll.removeFirst();
        ll.removeLast();

        System.out.println("ll after deleting first and last: " + ll);

        // get and set a value
        Object val = ll.get(2);
        ll.set(2, (String) val + " Changed");

        System.out.println("ll after change: " + ll);
    }
}
