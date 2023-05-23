package hello.jdbc.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class UncheckedTest {

    @Test
    void unchecked_test(){
        Service service = new Service();
        service.callCatch();
    }

    @Test
    void checked_throw(){
        Service service = new Service();
        assertThatThrownBy(service::callThrow)
                .isInstanceOf(MyUncheckedException.class);
    }

    /**
     * RuntimeException을 상속받으면 Unchecked 예외
     */
    static class MyUncheckedException extends RuntimeException {
        public MyUncheckedException(String message) {
            super(message);
        }
    }

    /**
     * Unchecked 예외는 잡거나 던지지 않아도 된다.
     * 예외를 잡지 않으면 자동으로 밖으로 던진다
     */
    static class Service{
        Repository repository = new Repository();

        /**
         * 필요하면 예외를 잡아서 처리
         */
        public void callCatch() {
            try {
                repository.call();
            } catch (MyUncheckedException e) {
                // 예외 처리 로직
                log.info("예외 처리, message={}", e.getMessage(), e);
            }
        }

        /**
         * 예외를 명시적으로 잡지 않아도 됨
         */
        public void callThrow(){
            repository.call();
        }
    }

    static class Repository { 
        public void call() {
            throw new MyUncheckedException("ex");
        }
    }
}
