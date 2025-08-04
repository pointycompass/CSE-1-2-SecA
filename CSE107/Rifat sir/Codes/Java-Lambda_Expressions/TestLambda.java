@FunctionalInterface
interface MyNumber {
    double getValue();
}

@FunctionalInterface
interface NumericTest {
    boolean test(int n);
}

@FunctionalInterface
interface NumericTest2 {
    boolean test(int n1, int n2);
}

@FunctionalInterface
interface NumericFunction {
    int func(int n);
}

@FunctionalInterface
interface StringFunction {
    String func(String n);
}

public class TestLambda {
    public static void main(String[] args) {
        MyNumber myNumber;
        myNumber = () -> 102.45;
        System.out.println(myNumber.getValue());
        myNumber = () -> Math.random() * 100;
        System.out.println(myNumber.getValue());

        NumericTest numericTest;
        numericTest = n -> n % 2 == 0;
        System.out.println(numericTest.test(107));
        numericTest = n -> n >= 0;
        System.out.println(numericTest.test(-10));

        NumericTest2 numericTest2;
        numericTest2 = (n1, n2) -> (n1 + n2) % 2 == 0;
        System.out.println(numericTest2.test(107, 5));
        numericTest2 = (n1, n2) -> (n1 + n2) >= 0;
        System.out.println(numericTest2.test(-20, 10));

        NumericFunction factorial;
        factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
            return result;
        };
        System.out.println(factorial.func(8));

        StringFunction stringFunction;
        stringFunction = (n) -> {
            String result = "";
            for (int i = n.length() - 1; i >= 0; i--) {
                result = result + n.charAt(i);
            }
            return result;
        };
        System.out.println(stringFunction.func("hello world"));
    }
}