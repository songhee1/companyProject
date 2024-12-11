package org.inputSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import jdk.internal.util.xml.impl.Input;
import org.domain.OrderEnum;

public class InputBundle {
    private InputBundle inputBundle;
    public InputBundle(){}

    public InputBundle getInputBundle() {
        return inputBundle;
    }

    public void setInputBundle(InputBundle inputBundle) {
        this.inputBundle = inputBundle;
    }

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public int orderOrQuit() throws IOException {
        System.out.print(OrderEnum.ORDER_START.getOrderData());
        String userInput = br.readLine();
        if(userInput.equals(OrderEnum.ORDER.getOrderData())) return 1;
        else return 0;
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
