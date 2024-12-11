package org.inputSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import jdk.internal.util.xml.impl.Input;
import org.domain.OrderEnum;

public class InputBundle {
    public InputBundle(){}

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public String orderOrQuitCommand() throws IOException {
        System.out.print(OrderEnum.ORDER_START.getOrderData());
        return br.readLine();
    }
    public int orderProduct() throws IOException {
        String userInputProductId = br.readLine();
        if(userInputProductId.isEmpty()){
            return 0;
        }else{
            return Integer.parseInt(userInputProductId);
        }
    }
}
