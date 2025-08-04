package generics;

class Stats<T extends Number> {
    T[] nums;

    Stats(T[] o) {
        nums = o;
    }

    double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    boolean sameAvg(Stats<T> obj) {
        if (average() == obj.average()) {
            return true;
        } else return false;
    }

    /*
    <S extends Number> boolean sameAvgAny(Stats<S> obj) {
        if (average() == obj.average()) {
            return true;
        } else return false;
    }
    */    

    boolean sameAvgAny(Stats<?> obj) {
        if (average() == obj.average()) {
            return true;
        } else return false;
    }
}

public class MyGenerics6 {
    public static void main(String[] args) {
        Integer[] n1 = {10, 20, 30, 40, 50};
        Stats<Integer> s1 = new Stats<>(n1);
        System.out.println(s1.average());

        Integer[] n2 = {50, 20, 40, 10, 30};
        Stats<Integer> s2 = new Stats<>(n2);
        System.out.println(s2.average());

        System.out.println(s1.sameAvg(s2));

        Double[] n3 = {50.0, 40.0, 30.0, 20.0, 10.0};
        Stats<Double> s3 = new Stats<>(n3);
        System.out.println(s3.average());

        System.out.println(s2.sameAvgAny(s3));
    }
}
