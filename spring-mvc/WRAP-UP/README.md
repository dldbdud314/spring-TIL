## WRAP-UP

![image](https://user-images.githubusercontent.com/57944099/170162752-5e889274-9aab-4ec3-a2d5-0606dc0abf70.png)

### 뷰 - 타임리프
- `th:xxx` : 서버사이드에서 렌더링 되고, 기존 것을 대체, th:xxx 없으면 기존 html의 xxx 속성 그대로 사용
- HTML을 파일로 직접 열었을 때, th:xxx 가 있어도 웹 브라우저는 th: 속성을 알지 못하므로 무시
- 따라서 HTML을 파일 보기를 유지하면서 템플릿 기능도 할 수 있다

👉 순수 HTML을 그대로 유지하면서 뷰 템플릿도 사용할 수 있는 타임리프의 특징을 네츄럴 템플릿이라 한다 

#### 기본 문법
- 사용 선언: `<html xmlns:th="http://www.thymeleaf.org">`

- URL 링크 표현식: `@{...}`

ex1. `th:href="@{/css/bootstrap.min.css}"` <br>
ex2. `th:href="@{/basic/items/{itemId}(itemId=${item.id})}"`
- 리터럴 대체: `|...|` 

ex. `th:onclick="|location.href='@{/basic/items/add}'|"`
- 변수 표현식: `${...}` 

ex. `<td th:text="${item.price}">10000</td>`
- 반복 출력: `th:each`

ex. `<tr th:each="item : ${items}">`

📌 [정적 뷰](https://github.com/dldbdud314/spring-web-dev-playground/tree/main/spring-mvc/item-service/src/main/resources/static)
📌 [동적 뷰 - 타임리프](https://github.com/dldbdud314/spring-web-dev-playground/tree/main/spring-mvc/item-service/src/main/resources/templates/basic)

### 컨트롤러
📌 [컨트롤러 코드](https://github.com/dldbdud314/spring-web-dev-playground/blob/main/spring-mvc/item-service/src/main/java/hello/itemservice/web/basic/BasicItemController.java)
- 상품 등록: `@RequestParam`, `@ModelAttribute`
- PRG 적용 (POST, Redirect, GET)

#### PRG?
- 마지막 요청이 POST인 경우, 새로고침 시 등록 작업 계속.. -> 데이터 쌓임
- 그래서 Redirect로 조회 페이지(GET) 호출 -> 새로고침 해도 ㄱㅊ
