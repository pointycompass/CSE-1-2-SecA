package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

class CustomRecursiveAction extends RecursiveAction {

    private String workload = "";
    private static final int THRESHOLD = 4;

    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length() > THRESHOLD) {
            invokeAll(createSubtasks());
        } else {
            processing(workload);
        }
    }

    private List<CustomRecursiveAction> createSubtasks() {
        List<CustomRecursiveAction> subTasks = new ArrayList<>();

        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2, workload.length());

        subTasks.add(new CustomRecursiveAction(partOne));
        subTasks.add(new CustomRecursiveAction(partTwo));

        return subTasks;
    }

    private void processing(String work) {
        String result = work.toUpperCase();
        System.out.println("This result - (" + result + ") - was processed by "
                + Thread.currentThread().getName());
    }
}

class CustomRecursiveTask extends RecursiveTask<Integer> {
    private int[] arr;
    private static final int THRESHOLD = 20;

    public CustomRecursiveTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (arr.length > THRESHOLD) {
            CustomRecursiveTask customRecursiveTaskA = new CustomRecursiveTask(
                    Arrays.copyOfRange(arr, 0, arr.length / 2));
            CustomRecursiveTask customRecursiveTaskB = new CustomRecursiveTask(
                    Arrays.copyOfRange(arr, arr.length / 2, arr.length));
            customRecursiveTaskA.fork();
            customRecursiveTaskB.fork();
            sum = customRecursiveTaskA.join() + customRecursiveTaskB.join();
            return sum;
        } else {
            return processing(arr);
        }
    }

    private Integer processing(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("This result - (" + sum + ") - was processed by "
                + Thread.currentThread().getName());
        return sum;
    }
}

public class ForkJoinTest {
    public static void main(String[] args) {
        /*
         * String alphabet =
         * "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
         * advanced.CustomRecursiveAction customRecursiveAction = new
         * advanced.CustomRecursiveAction(alphabet);
         * ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
         * forkJoinPool.invoke(customRecursiveAction);
         */

        int[] a = new int[10000];
        for (int i = 0; i < a.length; i++) {
            a[i] = 10;
        }
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(a);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        System.out.println(forkJoinPool.invoke(customRecursiveTask));
    }
}
