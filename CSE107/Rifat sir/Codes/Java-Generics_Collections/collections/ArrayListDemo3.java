package collections;

import java.util.ArrayList;
import java.util.List;

class MyClass {
    private int id;
    private String name;

    MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.name;
    }
}

public class ArrayListDemo3 {

    public static void main(String args[]) {
        // create an array list
        List<MyClass> al = new ArrayList<>();
        System.out.println("Initial size of al: " + al.size());

        // add elements to the array list
        al.add(new MyClass(1, "Rodgers"));
        al.add(new MyClass(2, "Bradley"));
        al.add(new MyClass(3, "Chambers"));
        al.add(new MyClass(4, "Calvin"));
        al.add(new MyClass(5, "Quinn"));
        al.add(new MyClass(6, "Mccoy"));

        System.out.println("Size of al after additions: " + al.size());

        // iterate
        for (int i = 0; i < al.size(); i++) {
            MyClass mc = al.get(i);
            System.out.println(mc.getId() + ", " + mc.getName());
        }
        System.out.println("");
    }
}