package data;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

public class CountedCompleterDemo {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length, null);

        // Khởi động tác vụ và chờ kết quả
        Integer result = pool.invoke(task);

        System.out.println("Tổng của mảng là: " + result);
    }

    static class SumTask extends CountedCompleter<Integer> {
        private static final int THRESHOLD = 3;
        private int[] array;
        private int start;
        private int end;
        private SumTask parentResult;

        public SumTask(int[] array, int start, int end, SumTask parent) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.parentResult = parent;
        }

//        @Override
//        public Integer getRawResult() {
//            return end - start <= THRESHOLD ? compute() : 0;
//        }

        @Override
        public void compute() {
            if (end - start <= THRESHOLD) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                // Kết thúc tác vụ và trả về kết quả
                propagateCompletion();
                return;
            }

            int middle = (start + end) >>> 1;
            SumTask leftTask = new SumTask(array, start, middle, this);
            SumTask rightTask = new SumTask(array, middle, end, this);

            // Chia tác vụ
            setPendingCount(1);
            leftTask.fork();
            rightTask.fork();
        }

        @Override
        public void onCompletion(CountedCompleter<?> caller) {
            if (caller != this) {
                parentResult.addToPendingCount(-1);
            }
        }

//        @Override
//        private void addToPendingCount(int value) {
//            int c;
//            do {
//                c = getPendingCount();
//            } while (!compareAndSetPendingCount(c, c + value));
//        }
    }
}
