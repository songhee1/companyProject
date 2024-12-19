package org.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.data.Data;
import org.program.OrderProgram;
import org.service.ProductServiceImpl;
import org.state.OrderContext;
import org.view.EndView;
import org.view.OrderView;
import org.view.ProductView;
import org.view.ReceiptView;
import org.view.StartView;

public class Main {
    public static void main(String[] args) throws IOException{

        Data.getItems();

        OrderProgram orderProgram = new OrderProgram(
        new BufferedReader(new InputStreamReader(System.in)),
        new StartView(),
        new EndView(),
        new ProductView(),
        new OrderView(),
        new ReceiptView(),
        new ProductServiceImpl(),
        new OrderContext()
        );

        orderProgram.programStart_new();

    }

}