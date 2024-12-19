package org.program;

import java.io.BufferedReader;
import java.io.IOException;
import org.domain.ShoppingBasket;
import org.domain.fsm.OrderEventEnum;
import org.inputSystem.InputBundle;
import org.service.ProductService;
import org.state.OrderContext;
import org.view.EndView;
import org.view.OrderView;
import org.view.ProductView;
import org.view.ReceiptView;
import org.view.StartView;

public class OrderProgram {
    private final BufferedReader br;
    private final StartView startView;
    private final EndView endView;
    private final ProductView productView;
    private final OrderView orderView;
    private final ReceiptView receiptView;
    private final ProductService productService;
    private final OrderContext orderContext;

    public OrderProgram(BufferedReader br, StartView startView, EndView endView,
        ProductView productView, OrderView orderView, ReceiptView receiptView,
        ProductService productService, OrderContext orderorderContext) {
        this.br = br;
        this.startView = startView;
        this.endView = endView;
        this.productView = productView;
        this.orderView = orderView;
        this.receiptView = receiptView;
        this.productService = productService;
        this.orderContext = orderorderContext;
    }

    public void programStart_new() throws IOException {
        while (play()) { // 주문일때만 들어감
            // 주문 시작
            orderContext.handleEvent(OrderEventEnum.OrderStartedEvent, br, productService, orderView, receiptView);
            productView.displayProductList(productService);
            selectProduct();
        }
        orderContext.handleEvent(OrderEventEnum.QuitEvent, br, productService, orderView, receiptView);
        endView.displayEnd();
    }

    private void selectProduct() throws IOException {
        orderContext.setBasket(new ShoppingBasket());
        do{
            // 상품 선택
            orderContext.handleEvent(OrderEventEnum.SelectProductEvent, br, productService, orderView, receiptView);
        }while(!order());
        orderContext.handleEvent(OrderEventEnum.ReceiptsIssuedEvent, br, productService, orderView, receiptView);
    }

    public boolean order() {
        return orderContext.getCommand();
    }

    public boolean play() throws IOException {
        // 주문 / 종료 뭐하실?
        startView.displayStartMessage();
        // 주문/종료 결정
        orderContext.handleEvent(OrderEventEnum.InitialWaitingEvent, br, productService, orderView, receiptView);
        return !orderContext.getCommand();
    }


}
