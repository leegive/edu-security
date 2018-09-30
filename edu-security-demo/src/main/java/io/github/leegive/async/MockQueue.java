package io.github.leegive.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author leegive
 */
@Component
public class MockQueue {

    private Logger log = LoggerFactory.getLogger(getClass());

    private String placeOrder;
    private String compleOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws InterruptedException {
       new Thread(() -> {
           log.info("接到下单请求，{}", placeOrder);
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           this.compleOrder = placeOrder;
           log.info("下单请求处理完毕！{}", compleOrder);
       }).start();
    }

    public String getCompleOrder() {
        return compleOrder;
    }

    public void setCompleOrder(String compleOrder) {
        this.compleOrder = compleOrder;
    }
}
