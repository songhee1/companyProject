package org.program;

import java.io.IOException;
import org.domain.OrderEnum;
import org.domain.ShoppingBasket;
import org.exception.UserException;
import org.inputSystem.InputBundle;
import org.outputSystem.OutputBundle;
import org.service.ProductService;
import org.service.ProductServiceImpl;

public class OrderProgram {
    private final InputBundle inputBundle = new InputBundle();
    private final OutputBundle outputBundle = OutputBundle.getOutputBundle();
    private final ProductService productService = new ProductServiceImpl();

    public void programStart() throws IOException {
        boolean isReset = false;
        while(inputBundle.orderOrQuitCommand().equals(OrderEnum.ORDER.getOrderData())){
            // 로직, 아키텍쳐적으로 bad..
            // SOLID 대충 그런 의미..지켜주면 좋다 --OCP에 취약하다, 수정이 쉽고 변경은 최소화필요
            // 핵심 : SHELL 작업 + 재고처리 후 동시성 thread safe..fsm
            outputBundle.printProductList(productService);
            ShoppingBasket basket = new ShoppingBasket();
            isReset = shoppingResetController(isReset, basket);
            if(isReset){
                isReset = false;
                continue;
            }
            CalculateProgram.calculatePaymentAmount(basket);
            outputBundle.printReceipt(basket);
        }
        outputBundle.printEnd();
    }

    private boolean shoppingResetController(boolean isReset, ShoppingBasket basket) throws IOException {
        for(;;){
            int productId = orderWithProductId();
            if(productId == 0){
                break;
            }
            int productAmount = orderWithProductAmount();
            try{
                productService.orderProduct(productId, productAmount);
                productService.addProductToBasket(productId, productAmount, basket);
            }catch(UserException exception){
                System.out.println(exception.getMessage());
                isReset = true;
                break;
            }
        }
        return isReset;
    }

    private int orderWithProductId() throws IOException {
        outputBundle.printToOrderProduct();
        return inputBundle.orderWithProductId(productService);
    }
    private int orderWithProductAmount() throws IOException {
        outputBundle.printToOrderProductAmount();
        return inputBundle.orderWithProductAmount();
    }
}
