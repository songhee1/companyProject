import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.data.Data;
import org.exception.UserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.service.ProductService;
import org.service.ProductServiceImpl;

public class ValidOrder {

    private final ProductService productService = new ProductServiceImpl();

    @Test
    @DisplayName("재고수보다 많은 주문 수량이 들어올 경우 SoldOutException이 발생한다.")
    public void validateMuliThreadSoldOut() throws InterruptedException, IOException {
        int numThreads = 50;
        int orderProductId = 782858;
        int requestAmount = 2;

        Data.getItems();

        CountDownLatch doneSignal = new CountDownLatch(numThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        AtomicInteger successCount = new AtomicInteger();
        AtomicInteger failCount = new AtomicInteger();

        for(int i=0;i<numThreads;i++){
            executorService.execute(()->{
                try{
                    productService.orderProduct(orderProductId, requestAmount);
                    successCount.getAndIncrement();
                }catch(UserException | IOException exception){
                    failCount.getAndIncrement();
                }finally {
                    doneSignal.countDown();
                }
            });
        }

        doneSignal.await();
        executorService.shutdown();

        assertAll(
            () -> assertThat(successCount.get()).isEqualTo(25),
            () -> assertThat(failCount.get()).isEqualTo(25)
        );
    }
}
