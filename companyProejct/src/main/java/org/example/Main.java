package org.example;

import java.io.IOException;
import org.controller.OrderProgramController;
import org.data.DataItem;
import org.exception.UserException;

public class Main {

    public static void main(String[] args) throws IOException, UserException {
        // 데이터 세팅
        // 1. 콤마로 나누어서 List<Product> 에 세팅해주기
        DataItem.setData();
        // 2. 컨트롤러-시스템 시작
        OrderProgramController.programStart();
    }
}