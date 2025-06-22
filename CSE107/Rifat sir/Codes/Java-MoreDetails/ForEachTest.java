public class ForEachTest {
    public static void main(String[] args) {
        int numbers[] = {1, 2, 3, 4, 5};
        for (int x : numbers) {
            System.out.print(x + " ");
            x = x * 10; // no effect on numbers
        }
        System.out.println();

        int numbers2[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] x : numbers2) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println("");
        }
    }
}
