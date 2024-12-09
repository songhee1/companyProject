package org.example;

import java.io.IOException;
import org.controller.OrderProgramController;

public class Main {

    public static void main(String[] args) throws IOException {
        // 데이터 세팅
        // 1. 콤마로 나누어서 List<Product> 에 세팅해주기

        // 2. 컨트롤러-시스템 시작
        // Controller.systemStart();
        OrderProgramController.programStart();
    }
}