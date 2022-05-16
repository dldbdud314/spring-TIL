## 스프링 MVC 구조 이해

![image](https://user-images.githubusercontent.com/57944099/168527524-33619033-f1ad-4437-8020-b1e8111e69ad.png)

#### **동작 순서**

1. **핸들러 조회**: 핸들러 매핑을 통해 요청 URL에 매핑된 핸들러(컨트롤러)를 조회
2. **핸들러 어댑터 조회**: 핸들러를 실행할 수 있는 핸들러 어댑터를 조회
3. **핸들러 어댑터 실행**
4. **핸들러 실행**
5. **ModelAndView 반환**: 핸들러 어댑터는 핸들러가 반환하는 정보를 ModelAndView로 변환하여 반환
6. **viewResolver 호출**
7. **View 반환**: 뷰 리졸버는 뷰의 논리 이름을 물리 이름으로 바꾸고, 렌더링 역할을 담당하는 뷰 객체를 반환
8. **뷰 렌더링**

📌 [과거 버전 스프링 Controller 인터페이스](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/servlet/src/main/java/hello/servlet/web/springmvc/old/OldController.java)

### 스프링 MVC

- 애노테이션 기반 컨트롤러 만들기
- `@RequestMapping`
  - `RequestMappingHandlerMapping`
  - `RequestMappingHandlerAdapter`
- `@Controller` -> 스프링 빈 등록 + 핸들러 등록
- `@Controller` 대신 `@Component @RequestMapping`같이 써도 똑같이 동작

📌 [V1 소스](https://github.com/dldbdud314/spring-web-dev-playground/tree/main/spring-mvc/servlet/src/main/java/hello/servlet/web/springmvc/v1)

**컨트롤러 통합** -> 클래스 레벨과 메서드 레벨을 조합하기

📌 [V2 소스](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/servlet/src/main/java/hello/servlet/web/springmvc/v2/SpringMemberControllerV2.java)

**실용적인 방식** -> ModelAndView 반환부 개선, `@RequestParam` 활용, HTTP 메소드 구분

📌 [V3 소스](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/servlet/src/main/java/hello/servlet/web/springmvc/v3/SpringMemberControllerV3.java)
