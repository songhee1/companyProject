package org.example;

import java.io.IOException;
import org.controller.OrderProgramController;
import org.data.Data;

public class Main {
    public static void main(String[] args) throws IOException{
        Data.getItems();
        OrderProgramController orderProgramController = new OrderProgramController();
        orderProgramController.programStart();
    }
}