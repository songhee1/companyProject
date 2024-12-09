package org.controller;

import java.io.IOException;
import org.data.DataItem;
import org.domain.ShoppingBasket;
import org.exception.UserException;
import org.inputSystem.InputBundle;
import org.outputSystem.OutputBundle;
import org.service.ProductService;
import org.validation.ValidateLogic;

public class OrderProgramController {
    private static ShoppingBasket basket;
    private static ProductService productService = new ProductService();
    public static void programStart() throws IOException, UserException {
        //Input 인스턴스 생성
        // 1. 주문 할건지 종료할건지 물어보고
        // 1-1. 주문이면 상품번호, 주문수량 입력
        // 1-2. 상품번호와 주문수량 모두 공백이면 주문 완료의 의미
        // 1-3.이 경우 주문금액 및 주문상품 출력 후 1로 이동
        // 2.종료하면 감사합니다 출력
        InputBundle inputBundle = new InputBundle();
        OutputBundle outputBundle = new OutputBundle();
        boolean isReset = false;
        while(inputBundle.orderOrQuit() == 1){
            outputBundle.printProductList();
            basket = new ShoppingBasket();
            for(;;){
                outputBundle.printToOrderProduct();
                int productId = inputBundle.orderProduct();
                if(productId == 0){
                    break;
                }
                outputBundle.printToOrderProductAmount();
                int productAmount = inputBundle.orderProduct();
                try{
                    productService.orderProduct(productId, productAmount);
                    productService.addProductToBasket(productId, productAmount, basket);
                }catch(UserException exception){
                    System.out.println(exception.getMessage());
                    isReset = true;
                    break;
                }
            }
            if(isReset){
                isReset = false;
                continue;
            }
            CalculateController.calculatePaymentAmount(basket);
            // 영수증 출력
            outputBundle.printReceipt(basket);
        }
        outputBundle.printEnd();
    }
}
