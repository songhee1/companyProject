package org.controller;

import java.io.IOException;
import org.domain.OrderEnum;
import org.domain.ShoppingBasket;
import org.exception.UserException;
import org.inputSystem.InputBundle;
import org.outputSystem.OutputBundle;
import org.service.ProductService;
import org.service.ProductServiceImpl;

public class OrderProgramController { //우리가 아는 컨트롤러랑 다르다
    //mvc 패턴->mc정도만 서버에서 담당 mvvc 개념만 알것!
    //이름이 어색하다
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
            CalculateController.calculatePaymentAmount(basket);
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
