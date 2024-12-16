package org.example;

import java.io.IOException;
import org.data.Data;
import org.domain.fsm.OrderEventEnum;
import org.state.OrderContext;

public class Main {
    public static void main(String[] args) throws IOException{
        Data.getItems();
        OrderContext context = new OrderContext();
        context.handleEvent(OrderEventEnum.InitialWaitingEvent);
//        OrderProgram orderProgramController = new OrderProgram();
//        orderProgramController.programStart();
    }
}