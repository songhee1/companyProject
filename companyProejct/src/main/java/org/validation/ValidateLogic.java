package org.validation;

import java.io.IOException;
import org.data.Data;
import org.domain.Product;
import org.exception.UserException;
import org.repository.ProductDAO;
import org.service.ProductService;

public class ValidateLogic {
    private static final String EXCEPTION_ORDER_AMOUNT_IS_BIGGER_THAN_STOCK_AMOUNT = "SoldOutException 발생. 주문한 상품량이 재고량보다 큽니다.";
    private static final String EXCEPTION_ORDER_COMMAND_IS_WRONG = "입력한 값은 o 또는 q가 아닙니다.";
    private static final String EXCEPTION_USE_STRING = "문자를 입력해야합니다.";
    private static final String EXCEPTION_USE_NUMBER = "숫자를 입력해야합니다.";
    private static final String EXCEPTION_NOT_EXIST_PRODUCT_ID = "해당 상품번호는 존재하지 않습니다.";


    public static void validateOrderAmount(int productId, int orderAmount, ProductDAO productDAO)
        throws UserException, IOException {
        int stockAmount = productDAO.getProduct(productId).getStockAmount();
        if(stockAmount < orderAmount){
            throw new UserException(EXCEPTION_ORDER_AMOUNT_IS_BIGGER_THAN_STOCK_AMOUNT);
        }
    }
    public static void validateOrderOrQuitCommand(String command) throws UserException {
        if(!command.equals("o") && !command.equals("q")){
            throw new UserException(EXCEPTION_ORDER_COMMAND_IS_WRONG);
        }
    }
    public static void validateIsString(String input) throws UserException {
        for(int i=0;i<input.length();i++){
            if(Character.isDigit(input.charAt(i))){
                throw new UserException(EXCEPTION_USE_STRING);
            }
        }
    }

    public static void validateIsNumber(String input) throws UserException {
        for(int i=0;i<input.length();i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new UserException(EXCEPTION_USE_NUMBER);
            }
        }
    }
    public static void validateProductId(String inputProductId, ProductService productService)
        throws UserException, IOException {
        boolean hasProductId = productService.hasProductId(Integer.parseInt(inputProductId));
        if(!hasProductId){
            throw new UserException(EXCEPTION_NOT_EXIST_PRODUCT_ID);
        }
    }
}



















