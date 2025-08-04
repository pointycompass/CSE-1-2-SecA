import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String args[]) {
        // create an array list
        List<Integer> al = new ArrayList<>();

        // add elements to the array list
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        al.add(50);

        al.forEach(e -> System.out.print(e + " "));
        System.out.println();

        Integer[] ia = { 10, 20, 30, 40, 50 };
        int[] a = { 10, 20, 30, 40, 50 };

        // streams
        List<Integer> streamList = Arrays.stream(ia).collect(Collectors.toList());
        streamList.forEach(e -> System.out.print(e + " "));
        System.out.println();

        // primitive type array to list
        List<Integer> integerList = Arrays.stream(a).boxed().collect(Collectors.toList());
        integerList.forEach(e -> System.out.print(e + " "));
        System.out.println();

        // create an array list
        List<MyClass> list = new ArrayList<>();

        // add elements to the array list
        list.add(new MyClass(1, "Rodgers"));
        list.add(new MyClass(2, "Bradley"));
        list.add(new MyClass(3, "Chambers"));
        list.add(new MyClass(4, "Calvin"));
        list.add(new MyClass(5, "Quinn"));
        list.add(new MyClass(6, "Mccoy"));

        List<String> names = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            MyClass mc = list.get(i);
            if (mc.getId() % 2 == 0)
                names.add(mc.getName());
        }

        // streams with map, filter, and collect
        List<String> nameList = list.stream().map(MyClass::getName).collect(Collectors.toList());
        nameList.forEach(e -> System.out.print(e + " "));
        System.out.println();

        List<Integer> evenIdList = list.stream().map(MyClass::getId).filter(e -> (e % 2 == 0))
                .collect(Collectors.toList());
        evenIdList.forEach(e -> System.out.print(e + " "));
        System.out.println();

        List<String> evenIdNameList = list.stream().filter(e -> (e.getId() % 2 == 0)).map(MyClass::getName)
                .collect(Collectors.toList());
        evenIdNameList.forEach(e -> System.out.print(e + " "));
        System.out.println();

        List<MyClass> evenIdObjectList = list.stream().filter(e -> (e.getId() % 2 == 0)).collect(Collectors.toList());
        evenIdObjectList.forEach(e -> System.out.print(e + " "));
        System.out.println();

        // parallel streams
        List<MyClass> evenIdObjectListParallel = list.parallelStream().filter(e -> (e.getId() % 2 == 0))
                .collect(Collectors.toList());
        evenIdObjectListParallel.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}