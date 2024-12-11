package org.validation;

import org.data.DataItem;
import org.domain.Product;
import org.exception.UserException;

public class ValidateLogic {
    private static final String EXCEPTION_ORDER_AMOUNT_IS_BIGGER_THAN_STOCK_AMOUNT = "SoldOutException 발생. 주문한 상품량이 재고량보다 큽니다.";
    private static final String EXCEPTION_ORDER_COMMAND_IS_WRONG = "입력한 값은 o 또는 q가 아닙니다.";
    private static final String EXCEPTION_USE_STRING = "문자를 입력해야합니다.";
    private static final String EXCEPTION_USE_NUMBER = "숫자를 입력해야합니다.";
    public static void validateOrderAmount(int productId, int orderAmount) throws UserException {
        Product product = DataItem.getMap().get(productId);
        if(product.getStockAmount()<orderAmount){
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
}



















