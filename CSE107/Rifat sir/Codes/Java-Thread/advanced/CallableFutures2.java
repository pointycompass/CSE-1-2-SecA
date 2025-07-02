package advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutures2 {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> taskList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            taskList.add(new MyCallable());
        }
        List<Future<Integer>> futureList = executor.invokeAll(taskList);
        int sum = 0;
        // Now retrieve the result
        for (Future<Integer> future : futureList) {
            sum += future.get();
        }
        System.out.println(sum);
        executor.shutdown();
    }
}