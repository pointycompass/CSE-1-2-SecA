import javax.swing.JOptionPane;

public class JOptionPaneTest {
    public static void main(String[] args) {
        String s1 = JOptionPane.showInputDialog(null,"Enter 1st Number:");
        String s2 = JOptionPane.showInputDialog(null,"Enter 2nd Number:");
        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);
        JOptionPane.showMessageDialog(null,"Sum is : " + (num1+num2));
    }
}
