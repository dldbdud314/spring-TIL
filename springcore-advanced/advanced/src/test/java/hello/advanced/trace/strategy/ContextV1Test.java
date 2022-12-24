package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.strategy.ContextV1;
import hello.advanced.trace.strategy.strategy.Strategy;
import hello.advanced.trace.strategy.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyMethodV0(){
        logic1();
        logic2();
    }

    private void logic1(){
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2(){
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyV1(){
        StrategyLogic1 logic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(logic1);
        contextV1.execute();

        StrategyLogic2 logic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(logic2);
        contextV2.execute();
    }

    @Test
    void strategyV2(){
        // 익명 내부 클래스 활용
        Strategy strategy1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        };
        ContextV1 contextV1 = new ContextV1(strategy1);
        log.info("strategyLogic1={}", strategy1.getClass());
        contextV1.execute();

        // 람다식 활용 : 인터페이스에 메소드가 한개만 있음
        Strategy strategy2 = () -> log.info("비즈니스 로직2 실행");
        ContextV1 contextV2 = new ContextV1(strategy2);
        log.info("strategyLogic2={}", strategy2.getClass());
        contextV2.execute();
    }

}
