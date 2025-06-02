package multi_threading.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSumExample extends RecursiveTask<Long> {
    private final int[] array;
    private final int start, end;
    private static final int THRESHOLD = 1000;

    public ForkJoinSumExample(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            ForkJoinSumExample leftTask = new ForkJoinSumExample(array, start, mid);
            ForkJoinSumExample rightTask = new ForkJoinSumExample(array, mid, end);
            leftTask.fork(); // Chạy leftTask bất đồng bộ
            return rightTask.compute() + leftTask.join(); // Chờ kết quả từ leftTask
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinSumExample task = new ForkJoinSumExample(array, 0, array.length);
        long result = pool.invoke(task);
        System.out.println("Sum: " + result);
    }
}