//task 1
package Java.lab7;
import java.util.concurrent.*;

public class ArraySumCalculator {

    static class SumTask implements Callable<Integer> { //интерфейс
        private final int[] array;
        private final int start;
        private final int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        }
    }

    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        int[] array = {
                1, 2, 3, 4, 5,
                6, 7, 8, 9, 10,
                11, 12, 13, 14, 15,
                16, 17, 18, 19, 20
        };
        int threadsCount = 4;

        //срвис распределяющий задчи по потокам
        ExecutorService executor = Executors.newFixedThreadPool(threadsCount);
        Future<Integer>[] futures = //"квитанции"
                new Future[threadsCount];
        int partSize = array.length / threadsCount;

        for (int i = 0; i < threadsCount; i++) {
            int start = i * partSize;
            int end = (i == threadsCount - 1) ? array.length : start + partSize;

            futures[i] = executor.submit(new SumTask(array, start, end));
        }

        int totalSum = 0;
        for (int i = 0; i < threadsCount; i++) {
            totalSum += futures[i].get();
        }
        executor.shutdown();
        System.out.println("Сумма массива: " + totalSum);
    }
}