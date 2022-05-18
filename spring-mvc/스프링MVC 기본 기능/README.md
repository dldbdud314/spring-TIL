## 스프링MVC 기본 기능

### 로깅
- [SLF4J](http://www.slf4j.org), [Logback](https://logback.qos.ch/)
- 레벨: TRACE > DEBUG > INFO > WARN > ERROR

📌 [로깅 활용 코드](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/spingmvc/src/main/java/hello/spingmvc/basic/LogTestController.java)
📌 [설정 정보](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/spingmvc/src/main/resources/application.properties)
📌 [more refs](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.logging)

### 요청 매핑
- [요청 매핑 코드](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/spingmvc/src/main/java/hello/spingmvc/basic/requestmapping/MappingController.java)
- [요청 매핑 API 코드](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/spingmvc/src/main/java/hello/spingmvc/basic/requestmapping/MappingClassController.java)

### HTTP 요청 - 기본, 헤더 조회
- [HTTP 기본 코드](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/spingmvc/src/main/java/hello/spingmvc/basic/request/RequestHeaderController.java)
- more refs (공식 문서)
  - [Controller 파라미터 목록 ref](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments)
  - [Controller 응답 값 목록 ref](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-return-types)

### HTTP 요청 파라미터 - 쿼리 파라미터+HTML Form, `@RequestParam`, `@ModelAttribute`
- GET 쿼리 파라미터, POST HTML Form 방식은 동일하게 요청 파라미터(request parameter) 조회 -> 형식: `username=aaa&age=20`
- `request.getParameter(XXX)`를
`````java
String username = request.getParameter("username");
int age = Integer.parseInt(request.getParameter("age"));
`````
👉 `@RequestParam`으로 처리
````java
@RequestParam(defaultValue = "guest") String username,
@RequestParam(required = false, defaultValue = "-1") int age
````

- `@ModelAttribute`: request-객체 매핑
````java
@RequestParam String username;
@RequestParam int age;

HelloData data = new HelloData();
data.setUsername(username);
data.setAge(age);
````
👉 `@ModelAttribute HelloData data`

📌 [요청 파라메터 코드](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/spingmvc/src/main/java/hello/spingmvc/basic/request/RequestParamController.java)

### HTTP 요청 메시지 - 단순 텍스트
- HTTP message body에 데이터를 직접 담아서 요청 (!= HTTP 요청 파라미터 처리: `@RequestParam`, `@ModelAttribute`)
- 스프링MVC 파라메터 지원
  - `HttpEntity`: HTTP header, body 정보를 편리하게 조회
    - `RequestEntity`(요청), `ResponseEntity`(응답)
  - `@RequestBody`: HTTP 메시지 바디 정보를 편리하게 조회

📌 [HTTP 요청 파라메터(단순 텍스트) 코드](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/spingmvc/src/main/java/hello/spingmvc/basic/request/RequestBodyStringController.java)

### HTTP 요청 메시지 - JSON
- **HttpMessageConverter** 사용
`````java
HelloData data = objectMapper.readValue(messageBody, HelloData.class);
`````

👉 `@RequestBody`, `@ResponseBody`
`````java
@ResponseBody
@PostMapping("/request-body-json-v5")
public HelloData requestBodyJsonV5(@RequestBody HelloData data) {
    log.info("username={}, age={}", data.getUsername(), data.getAge());
    return data;
}
`````

👉 `HttpEntity` 사용해도 무방
````java
public String requestBodyJsonV4(HttpEntity<HelloData> httpEntity) {
   HelloData data = httpEntity.getBody();
   ...
}
````

📌 [HTTP 요청 파라메터(JSON) 코드](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/spingmvc/src/main/java/hello/spingmvc/basic/request/RequestBodyJsonController.java)

### HTTP 응답 - 정적 리소스, 뷰 템플릿
- 응답 데이터 만드는 방식 세가지: 1) 정적 리소스, 2) 뷰 템플릿 사용, 3) HTTP 메시지 사용
- 정적 리소스 경로: _src/main/resources/static_
- 뷰 템플릿 경로: _src/main/resources/templates_

📌 [HTTP 응답(뷰) 코드](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/spingmvc/src/main/java/hello/spingmvc/basic/response/ResponseViewController.java)

### HTTP 응답 - HTTP API, 메시지 바디에 직접 입력
📌 [HTTP 응답(HTTP API) 코드](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/spingmvc/src/main/java/hello/spingmvc/basic/response/ResponseBodyController.java)
