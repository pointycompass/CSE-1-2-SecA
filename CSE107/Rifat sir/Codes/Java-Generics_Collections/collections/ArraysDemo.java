package collections;

import java.util.Arrays;

class ArraysDemo {
    public static void main(String args[]) {

        // allocate and initialize array
        int array[] = new int[10];
        for (int i = 0; i < 10; i++)
            array[i] = -3 * i;

        // display, sort, display
        System.out.print("Original contents: ");
        display(array);
        Arrays.sort(array);
        System.out.print("Sorted: ");
        display(array);


        // fill and display
        Arrays.fill(array, 2, 6, -1);
        System.out.print("After fill(): ");
        display(array);


        // sort and display
        Arrays.sort(array);
        System.out.print("After sorting again: ");
        display(array);


        // binary search for -9
        System.out.print("The value -9 is at location ");
        int index = Arrays.binarySearch(array, -9);
        System.out.println(index);
    }

    static void display(int array[]) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println("");
    }
}
