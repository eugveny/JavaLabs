//task 2
package Java.lab7;
import java.util.concurrent.*;

public class MatrixMaxFinder {

    static class MaxTask implements Callable<Integer> {
        private final int[][] matrix;
        private final int startRow;
        private final int endRow;

        public MaxTask(int[][] matrix, int startRow, int endRow) {
            this.matrix = matrix;
            this.startRow = startRow;
            this.endRow = endRow;
        }

        @Override
        public Integer call() {
            int max = Integer.MIN_VALUE;
            for (int i = startRow; i < endRow; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        int[][] matrix = {
                {12, 7, 45, 3},
                {18, 90, 2, 15},
                {33, 21, 54, 11},
                {10, 8, 6, 100},
                {44, 77, 5, 9},
                {31, 22, 88, 14}
        };
        int threadsCount = 3;

        ExecutorService executor = Executors.newFixedThreadPool(threadsCount);
        Future<Integer>[] futures = new Future[threadsCount];
        int rowsPerThread = matrix.length / threadsCount;

        for (int i = 0; i < threadsCount; i++) {
            int startRow = i * rowsPerThread;
            int endRow = (i == threadsCount - 1) ? matrix.length : startRow + rowsPerThread;

            futures[i] = executor.submit(
                    new MaxTask(matrix, startRow, endRow)
            );
        }

        int globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < threadsCount; i++) {
            int localMax = futures[i].get();
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        executor.shutdown();
        System.out.println("Наибольший элемент: " + globalMax);
    }
}