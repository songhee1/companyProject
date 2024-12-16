package org.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.domain.fsm.OrderEventEnum;
import org.exception.UserException;
import org.outputSystem.OutputBundle;
import org.service.ProductService;
import org.validation.ValidateLogic;

public class ActiveProductState implements State {

    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event,
        ProductService productService, OutputBundle outputBundle)
        throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2. 상품번호 작성
        // ➡️ 상품번호 불량이면 OrderState로 이동
        // 3. ActiveAmountState

        switch (event) {
            case SelectAmountEvent:
                context.setState(new ActiveAmountState());
                System.out.println("active amount state 진입");

                break;
            case OrderRejectedEvent:
                context.setState(new InactiveState());
                System.out.println("inactive state 진입");
                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
