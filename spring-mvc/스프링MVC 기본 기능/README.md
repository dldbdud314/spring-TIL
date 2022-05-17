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

### HTTP 요청 파라미터 - 쿼리 파라미터, HTML Form
- GET 쿼리 파라미터, POST HTML Form 방식은 동일하게 요청 파라미터(request parameter) 조회 -> 형식: `username=aaa&age=20`

📌 [요청 파라메터 코드](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/spingmvc/src/main/java/hello/spingmvc/basic/request/RequestParamController.java)

