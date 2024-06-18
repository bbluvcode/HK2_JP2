import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // supplyAsync(): Tạo một CompletableFuture với kết quả trả về là "Hello"
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync() running on thread: " + Thread.currentThread().getName());
            return "Hello";
        });

        // thenApply(): Thực hiện một phép biến đổi trên kết quả của CompletableFuture
        CompletableFuture<String> thenApplyFuture = future.thenApply(result -> {
            System.out.println("thenApply() running on thread: " + Thread.currentThread().getName());
            return result + " World";
        });

        // thenAccept(): Thực hiện một hành động mà không trả về kết quả
        thenApplyFuture.thenAccept(result -> {
            System.out.println("thenAccept() running on thread: " + Thread.currentThread().getName());
            System.out.println(result);
        });

        // whenComplete(): Thực hiện một hành động khi CompletableFuture hoàn thành, có hoặc không có lỗi
        CompletableFuture<String> whenCompleteFuture = thenApplyFuture.whenComplete((result, throwable) -> {
            if (throwable != null) {
                System.out.println("Exception occurred: " + throwable.getMessage());
            } else {
                System.out.println("whenComplete() running on thread: " + Thread.currentThread().getName());
                System.out.println("Completed successfully with result: " + result);
            }
        });

        // join(): Chờ đợi và trả về kết quả của CompletableFuture
        System.out.println("Result from join(): " + whenCompleteFuture.join());

        // getNow(): Trả về giá trị của CompletableFuture hoặc giá trị mặc định nếu chưa hoàn thành
        String futuree = future.getNow("Default Value");
        System.out.println("Future from getNow(): " + futuree);
        
                String thenApply = thenApplyFuture.getNow("Default Value");
        System.out.println("thenApply from getNow(): " + thenApply);
    }
}
