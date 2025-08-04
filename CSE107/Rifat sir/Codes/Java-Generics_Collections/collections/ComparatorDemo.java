package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TestClassComparator implements Comparator<TestClass> {
    @Override
    public int compare(TestClass o1, TestClass o2) {
        //return o1.getName().compareTo(o2.getName());
        return o1.getId() - o2.getId();
    }
}

class TestClass implements Comparable<TestClass> {

    private String name;
    private int id;

    TestClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public int compareTo(TestClass o) {
        //return this.id - o.getId();
        return this.name.compareTo(o.name);
    }
}

class ComparatorDemo {

    public static void printList(List<TestClass> al) {
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i).getId() + ", " + al.get(i).getName());
        }
        System.out.println();
    }

    public static void main(String args[]) {
        List<TestClass> al = new ArrayList<>();

        al.add(new TestClass(1, "C"));
        al.add(new TestClass(3, "A"));
        al.add(new TestClass(2, "E"));
        al.add(new TestClass(5, "B"));
        al.add(new TestClass(4, "D"));
        al.add(new TestClass(6, "F"));

        printList(al);
        Collections.sort(al);
        printList(al);
        Collections.sort(al, new TestClassComparator());
        printList(al);
    }
}