package hello.proxy.jdkdynamic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0() {
        Hello target = new Hello();

        // 공통 로직1 시작
        log.info("Start");
        String result1 = target.callA(); // 호출하는 메서드만 다름
        log.info("result1={}", result1);
        // 공통 로직1 종료

        // 공통 로직2 시작
        log.info("Start");
        String result2 = target.callB();
        log.info("result2={}", result2);
        // 공통 로직2 종료
    }

    @Test
    void reflection1() throws Exception {
        // 클래스 정보
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        // callA의 메소드 정보
        Method callA = classHello.getMethod("callA");
        Object result1 = callA.invoke(target);
        log.info("result1={}", result1);

        // callB의 메소드 정보
        Method callB = classHello.getMethod("callB");
        Object result2 = callB.invoke(target);
        log.info("result2={}", result2);
    }

    @Test
    void reflection2() throws Exception {
        // 클래스 정보
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        // callA의 메소드 정보
        Method callA = classHello.getMethod("callA");
        dynamicCall(callA, target);

        // callB의 메소드 정보
        Method callB = classHello.getMethod("callB");
        dynamicCall(callB, target);
    }

    private void dynamicCall(Method method, Object target) throws Exception {
        log.info("Start");
        Object result = method.invoke(target);
        log.info("result={}", result);
    }

    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}
