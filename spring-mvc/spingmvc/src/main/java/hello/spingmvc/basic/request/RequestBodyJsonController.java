package hello.spingmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.spingmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * {"username":"hello", "age":20}
 * content-type: application/json
 */
@Slf4j
@Controller
public class RequestBodyJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        response.getWriter().write("ok");
    }

    /**
     * @RequestBody
     * @ResponseBody
     * */
    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {
        log.info("messageBody={}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class); //자바 객체로 변환
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }


    /**
     * @RequestBody
     * 바로 HelloData 적용 -> 알아서 컨버팅 작업 되서 받을 수 있음
     * 주의: @RequestBody 생략 불가능 -> 생략 시 @ModelAttribute로 해석
     */
    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyJsonV3(@RequestBody HelloData helloData){
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    /**
     * HttpEntity로 body 받기 - HelloData 객체로 변환
     */
    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public String requestBodyJsonV4(HttpEntity<HelloData> httpEntity){
        HelloData data = httpEntity.getBody();
        log.info("username={}, age={}", data.getUsername(), data.getAge());
        return "ok";
    }

    /**
     * 들어올 때도, 나갈 때도 HelloData 적용 가능
     * Json(@RequestBody 요청) -> (Http 메시지 컨버터) -> 객체 -> (Http 메시지 컨버터) -> Json(@ResponseBody 응답)
     */
    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData requestBodyJsonV5(@RequestBody HelloData helloData){
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return helloData;
    }
}
