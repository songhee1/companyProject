import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.concurrent.atomic.AtomicInteger;
import org.exception.UserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.validation.ValidateLogic;

public class ValidInputTest {
    @Test
    @DisplayName("주문 혹은 종료 명령어 이외의 문자열로 된 명령어는 실패하는 테스트")
    public void validateOrderOrQuitCommandByString(){
        String testCommand = "wrong command";

        AtomicInteger successCount = new AtomicInteger();
        AtomicInteger failCount = new AtomicInteger();

        try{
            ValidateLogic.validateOrderOrQuitCommand(testCommand);
            successCount.getAndIncrement();
        }catch(UserException exception){
            failCount.getAndIncrement();
        }

        assertAll(
            ()->assertThat(successCount.get()).isEqualTo(0),
            ()->assertThat(failCount.get()).isEqualTo(1)
        );

    }
    @Test
    @DisplayName("주문 혹은 종료 명령어 이외의 숫자로 된 명령어는 실패하는 테스트")
    public void validateOrderOrQuitCommandByNumber(){
        String testCommand = "34532";

        AtomicInteger successCount = new AtomicInteger();
        AtomicInteger failCount = new AtomicInteger();

        try{
            ValidateLogic.validateOrderOrQuitCommand(testCommand);
            successCount.getAndIncrement();
        }catch(UserException exception){
            failCount.getAndIncrement();
        }

        assertAll(
            ()->assertThat(successCount.get()).isEqualTo(0),
            ()->assertThat(failCount.get()).isEqualTo(1)
        );

    }
}
