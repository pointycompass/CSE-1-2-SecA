class StackEmptyException extends Exception
{
    String message;

    StackEmptyException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}

class StackFullException extends Exception
{
    String message;
    int value;

    StackFullException(String message, int value) {
        this.message = message;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.message + ": " + this.value;
    }
}

class Stack {
    private int top;
    private int [] s;
    public static final int SIZE = 5;

    Stack() {
        this.s = new int[SIZE];
        top = -1;
    }

    public void push(int a) throws StackFullException {
        if (top >= SIZE - 1) {
            throw new StackFullException("This stack is full!", a);
        }
        s[++top] = a;
    }

    public int pop() throws StackEmptyException {
        if (top == -1) {
            throw new StackEmptyException("This stack is empty!");
        }
        return s[top--];
    }
}

public class StackExceptionTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(6);
        } catch(StackFullException e) {
            System.out.println(e);
        }
        try {
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
        } catch(StackEmptyException e) {
            System.out.println(e);
        }
    }
}