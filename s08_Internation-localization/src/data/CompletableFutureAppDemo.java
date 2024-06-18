package data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureAppDemo {

    public static void main(String[] args) {
        // 1. Xử lý Dữ liệu từ Nhiều Nguồn
        CompletableFuture<String> fetchUserData = CompletableFuture.supplyAsync(() -> {
            // Lấy dữ liệu người dùng
            return "User Data";
        });

        CompletableFuture<String> fetchProductData = CompletableFuture.supplyAsync(() -> {
            // Lấy dữ liệu sản phẩm
            return "Product Data";
        });

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(fetchUserData, fetchProductData);

        combinedFuture.thenRun(() -> {
            try {
                String userData = fetchUserData.get();
                String productData = fetchProductData.get();
                System.out.println("Combined Data: " + userData + " - " + productData);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        // 2. Retry Logic
        CompletableFuture<String> retryFuture = CompletableFuture.supplyAsync(() -> {
            // Thực hiện một tác vụ có thể thất bại
            return "Result";
        }).exceptionally(e -> {
            System.out.println("Error occurred: " + e.getMessage());
            // Thử lại sau 1 giây
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return null;
        });

        // 3. Kết hợp và Chuyển đổi Dữ liệu
        CompletableFuture<String> transformFuture = CompletableFuture.supplyAsync(() -> {
            // Thực hiện một tác vụ và trả về một số
            return 10;
        }).thenApply(result -> {
            // Chuyển đổi kết quả sang String
            return "Result: " + result;
        });

        // 4. Chạy Đa luồng và Thống nhất
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            // Tính toán phần 1
            return 1;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            // Tính toán phần 2
            return 2;
        });

        CompletableFuture<Integer> combinedFuture2 = future1.thenCombine(future2, (result1, result2) -> {
            // Kết hợp kết quả từ cả hai phần
            return result1 + result2;
        });

        combinedFuture2.thenAccept(result -> {
            System.out.println("Combined Result: " + result);
        });
    }
}
