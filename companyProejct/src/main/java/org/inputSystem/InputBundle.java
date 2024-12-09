package org.inputSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputBundle {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public int orderOrQuit() throws IOException {
        String userInput = br.readLine();
        if(userInput.equals("o")) return 1;
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
