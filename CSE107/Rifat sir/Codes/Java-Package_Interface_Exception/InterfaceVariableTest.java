import java.util.Random;

interface SharedConstants {
    int NO = 1;
    int YES = 2;
}

class Question implements SharedConstants {
    Random rand = new Random();
    int ask() {
        int prob = (int) (100 * rand.nextDouble());
        if (prob < 50) return NO;
        else return YES;
    }
}
public class InterfaceVariableTest {
    public static void main(String[] args) {
        Question q = new Question();
        for (int i = 0; i < 10; i++) {
            System.out.println(q.ask());
        }
    }
}
