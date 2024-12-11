package org.controller;

import java.io.IOException;
import org.domain.ShoppingBasket;
import org.exception.UserException;
import org.inputSystem.InputBundle;
import org.outputSystem.OutputBundle;
import org.service.ProductService;
import org.service.ProductServiceImpl;

public class OrderProgramController {
    private final InputBundle inputBundle = new InputBundle();
    private final OutputBundle outputBundle = new OutputBundle();
    private final ProductService productService = new ProductServiceImpl();
    public void programStart() throws IOException, UserException {
        boolean isReset = false;
        while(inputBundle.orderOrQuit() == 1){
            outputBundle.printProductList();
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
        return isReset;
    }
}
