package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {

    private final Component realComponent;

    public MessageDecorator(Component component) {
        this.realComponent = component;
    }


    @Override
    public String operation() {
        log.info("MessageDecorator 실행");
        String result = realComponent.operation();
        String decoResult = "*****" + result + "*****";
        log.info("MessageDecorator 꾸미기 적용 전={} 적용 후={}", result, decoResult);
        return decoResult;
    }
}
