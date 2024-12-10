package org.controller;

import java.io.IOException;
import org.domain.ShoppingBasket;
import org.exception.UserException;
import org.inputSystem.InputBundle;
import org.outputSystem.OutputBundle;
import org.service.ProductService;

public class OrderProgramController {
    private static ProductService productService = new ProductService();
    public static void programStart() throws IOException, UserException {
        InputBundle inputBundle = new InputBundle();
        OutputBundle outputBundle = new OutputBundle();
        boolean isReset = false;
        while(inputBundle.orderOrQuit() == 1){
            outputBundle.printProductList();
            ShoppingBasket basket = new ShoppingBasket();
            isReset = shoppingResetController(outputBundle, inputBundle, isReset, basket);
            if(isReset){
                isReset = false;
                continue;
            }
            CalculateController.calculatePaymentAmount(basket);
            outputBundle.printReceipt(basket);
        }
        outputBundle.printEnd();
    }

    private static boolean shoppingResetController(OutputBundle outputBundle, InputBundle inputBundle,
        boolean isReset, ShoppingBasket basket) throws IOException {
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
