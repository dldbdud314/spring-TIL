## 동시성 문제

하나의 인스턴스에 여러 쓰레드가 동시에 접근하는 경우 발생

![image](https://user-images.githubusercontent.com/57944099/208605176-598bd7d8-dcfc-4933-8c84-084b3078a629.png)

📌 [예시 코드](https://github.com/dldbdud314/spring-TIL/blob/main/springcore-advanced/advanced/src/test/java/hello/advanced/trace/threadlocal/FieldServiceTest.java)

### 참고

- 지역변수에선 발생하지 않음 (stack영역은 상관없음)
