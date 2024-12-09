package org.outputSystem;

public class OutputBundle {
    public void printEnd(){
        System.out.println("고객님의 주문 감사합니다.");
    }
    public void printToOrderProduct(){
        System.out.print("상품번호 : ");
    }
    public void printToOrderProductAmount(){
        System.out.print("수량 : ");
    }
}
