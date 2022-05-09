## 서블릿과 JSP
### 서블릿
- Java 코드에 html 넣기<br>
👉 _화면에 뿌릴 html 코드를 개발자가 java 코드로 한땀한땀 적는다!_
#### ex. [서블릿 코드 예제](https://github.com/dldbdud314/spring-web-dev-playground/tree/main/spring-mvc/servlet/src/main/java/hello/servlet/web/servlet)

🤦🏻‍♀️ java 코드로 html 문서를 만들기보다는 html 문서에 동적으로 변경해야 하는 부분만 java 코드를 넣을 수 있으면 좋을텐데...<br>
그래서 나온 게 👉 **템플릿 엔진**

👀 **템플릿 엔진?** 껍데기(template)이 있고 중간중간에 값을 변경할 수 있다 (동적인 작업을 위한 코드 삽입 가능)

### JSP
- JSP는 템플릿 엔진이다.
- 반대로 HTML 코드에 Java 코드 넣기

#### ex. [JSP 코드 예제](https://github.com/dldbdud314/spring-web-dev-playground/tree/main/spring-mvc/servlet/src/main/webapp/jsp)

### 서블릿과 JSP의 한계
1. **서블릿**
- 뷰 화면을 위한 html을 만드는 작업이 번거롭다
- JSP는 뷰 생성을 깔끔하게 만들어줌 (템플릿엔진의 역할)

2. **JSP**
- 비즈니스 로직과 뷰 렌더링 작업이 뒤섞여있다
- Java 코드, 데이터 조회(repository 접근) 등 **너무 많은 역할을 담당한다**
- 유지보수 헬 파티 예약💩

3. 그래서 등장한 게 **MVC 패턴**
