## 프론트컨트롤러
👉 뷰, 컨트롤러, 모델을 분리하는 점진적 리팩토링 과정

- 프론트 컨트롤러에서 공통 기능을 처리
- 스프링 웹 MVC의 핵심이 프론트 컨트롤러다!

### V1. 프론트컨트롤러의 도입
![image](https://user-images.githubusercontent.com/57944099/167754571-8b77c4fa-5eb9-4dc6-bc71-54c1563190f6.png)

📌 [V1 코드](https://github.com/dldbdud314/spring-web-dev-playground/tree/main/spring-mvc/servlet/src/main/java/hello/servlet/web/frontcontroller/v1)

### V2. View 분리
![image](https://user-images.githubusercontent.com/57944099/167754987-f134a335-67a6-4d54-8f22-86cdd4e81f22.png)

📌 [V2 코드](https://github.com/dldbdud314/spring-web-dev-playground/tree/main/spring-mvc/servlet/src/main/java/hello/servlet/web/frontcontroller/v2)

### V3. Model 추가
![image](https://user-images.githubusercontent.com/57944099/167794182-3213596d-15d2-4ca0-ae6e-5284238afcef.png)

📌 [V3 코드](https://github.com/dldbdud314/spring-web-dev-playground/tree/main/spring-mvc/servlet/src/main/java/hello/servlet/web/frontcontroller/v3)<br>
📌 [코드 설명](https://velog.io/@dldbdud314/%EC%84%B9%EC%85%984-%EC%A4%91-%EB%B7%B0-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC-%EB%AA%A8%EB%8D%B8-%EB%B6%84%EB%A6%AC)

### V4. 실용성 UP - 뷰 이름만 반환하도록 변경
![image](https://user-images.githubusercontent.com/57944099/168006539-0fab61ba-d530-4da4-b6a4-0cd41770da2a.png)

📌 [V4 코드](https://github.com/dldbdud314/spring-web-dev-playground/tree/main/spring-mvc/servlet/src/main/java/hello/servlet/web/frontcontroller/v4)

### V5. 어댑터 패턴의 적용
![image](https://user-images.githubusercontent.com/57944099/168006103-cf8810cb-70d0-4ef9-8bb8-c6f338d8bf5c.png)

📌 [V5 코드](https://github.com/dldbdud314/spring-web-dev-playground/tree/main/spring-mvc/servlet/src/main/java/hello/servlet/web/frontcontroller/v5)<br>
📌 [코드 설명](https://velog.io/@dldbdud314/%EC%84%B9%EC%85%984-%EC%A4%91-V5%EC%9D%98-%EC%A3%BC%EC%9A%94-%EA%B0%9C%EB%85%90%EA%B3%BC-%EC%8B%A4%ED%96%89-%ED%9D%90%EB%A6%84-%EB%94%B0%EB%9D%BC%EA%B0%80%EA%B8%B0)
