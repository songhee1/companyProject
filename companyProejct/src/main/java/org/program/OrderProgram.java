package org.program;

import java.io.BufferedReader;
import java.io.IOException;
import org.domain.fsm.OrderEventEnum;
import org.inputSystem.InputBundle;
import org.outputSystem.OutputBundle;
import org.service.ProductService;
import org.state.OrderContext;
import org.view.EndView;
import org.view.ProductView;
import org.view.StartView;

public class OrderProgram {
    private final BufferedReader br;
    private final OutputBundle outputBundle;
    private final StartView startView;
    private final EndView endView;
    private final ProductView productView;
    private final InputBundle inputBundle;
    private final ProductService productService;
    private final OrderContext orderContext;

    public OrderProgram(BufferedReader br, OutputBundle outputBundle, StartView startView, EndView endView,
        ProductView productView, InputBundle inputBundle, ProductService productService, OrderContext orderorderContext) {
        this.br = br;
        this.outputBundle = outputBundle;
        this.startView = startView;
        this.endView = endView;
        this.productView = productView;
        this.inputBundle = inputBundle;
        this.productService = productService;
        this.orderContext = orderorderContext;
    }

    public void programStart_new() throws IOException {
        while (play()) { // 주문일때만 들어감
            // 주문 시작
            orderContext.handleEvent(OrderEventEnum.OrderStartedEvent, br, productService);
            productView.displayProductList(productService);
            selectProduct();
        }
        orderContext.handleEvent(OrderEventEnum.QuitEvent, br, productService);
        endView.displayEnd();
    }

    private void selectProduct() throws IOException {
        do{
            // 상품 선택
            orderContext.handleEvent(OrderEventEnum.SelectProductEvent, br, productService);
            if(orderContext.getCommand()) return;
        }while(order());
        orderContext.handleEvent(OrderEventEnum.ReceiptsIssuedEvent, br, productService);
    }

    public boolean order() {
        return orderContext.getCommand();
    }

    public boolean play() throws IOException {
        // 주문 / 종료 뭐하실?
        startView.displayStartMessage();
        // 주문/종료 결정
        orderContext.handleEvent(OrderEventEnum.InitialWaitingEvent, br, productService);
        return orderContext.getCommand();
    }


}
