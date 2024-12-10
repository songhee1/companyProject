package org.example;

import java.io.IOException;
import org.controller.OrderProgramController;
import org.data.DataItem;
import org.exception.UserException;

public class Main {

    public static void main(String[] args) throws IOException, UserException {
        DataItem.setData();
        OrderProgramController.programStart();
    }
}