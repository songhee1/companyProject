package org.example;

import java.io.IOException;
import org.program.OrderProgram;
import org.data.Data;

public class Main {
    public static void main(String[] args) throws IOException{
        Data.getItems();
        OrderProgram orderProgramController = new OrderProgram();
        orderProgramController.programStart();
    }
}