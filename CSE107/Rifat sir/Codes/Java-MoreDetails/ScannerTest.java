import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int a = scn.nextInt();
        System.out.println("Enter a string: ");
        String b = scn.next();
        System.out.println("You Entered: ");
        System.out.println(a);
        System.out.println(b);
        System.out.println("Enter a series of integers: Ctrl-D to stop");
        while(scn.hasNextInt())
        {
            System.out.println(scn.nextInt());
        }
        /*while(scn.hasNextLine())
        {
            System.out.println(scn.nextLine());
        }*/
        scn.close();
    }
}
