public class VarDemo {
    public static void main(String[] args) {
        var avg = 10.0;
        System.out.println(avg);

        int var = 1;
        System.out.println(var);

        var x = -var;
        System.out.println(x);

        // var y; // error
        // var z = null; // error

        var a   = new int[10];
        for(int i : a) {
            System.out.print(i);
        }
        System.out.println();
        for(var i : a) {
            System.out.print(i);
        }
        System.out.println();

        for(var k = 1; k < 10; k++) {
            System.out.print(k);
        }
        System.out.println();

        //var [] b = new int[10]; // error
        //var b[] = new int[10]; // error
        // var b = {1, 2, 3}; // error
    }
}
