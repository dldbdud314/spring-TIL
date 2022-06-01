## JBDC

### JDBC 표준 인터페이스

![image](https://user-images.githubusercontent.com/57944099/171349918-33a04c29-064f-4fe6-8d83-a0b4206d2844.png)

#### JDBC로 해결된 건,,
- DB 사용 코드 변경 필요 없음, 왜냐하면 추상화에 의존하기 때문 (JDBC API)
- 각각의 DB를 학습할 필요 X

하지만 SQL문은 각 DB에 맞게 변경할 필요 O -> 이건 또 JPA로 어느정도 해소할 수 있음!

### JDBC와 최신 데이터 접근 기술: SQL Mapper, ORM
- JDBC API 직접 사용하는 경우:
> 애플리케이션 로직 -_SQL_-> JDBC

- SQL Mapper
> 애플리케이션 로직 -_SQL_-> SQL Mapper -> JDBC

- ORM
> 애플리케이션 로직 -_객체_-> JPA -> JPA 구현체 -_SQL_-> JDBC

#### SQL Mapper vs. ORM
공통적으로 결국엔 JDBC API 호출
- SQL Mapper: SQL만 개발자가 직접 작성하면 나머지 번잡한 작업은 SQL Mapper가 대신 해결해준다
- ORM: 개발자가 직접 SQL을 작성해야한다는 불편함마저도 해결, 대신 러닝커브가 있음 

### JDBC API 활용: CRUD
📌 [구현 코드](https://github.com/dldbdud314/spring-TIL/blob/main/db-1/jdbc/src/main/java/hello/jdbc/repository/MemberRepositoryV0.java)
