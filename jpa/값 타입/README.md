### JPA의 데이터 타입 분류

- 엔티티 타입 : `@Entity`로 정의하는 객체, 식별자로 추적 가능

- 값 타입 : 단순히 값으로 사용하는 자바 기본 타입이나 객체, 추적 불가, 생명주기를 엔티티의 의존

- 값 타입 분류)
  - 기본값 타입: primitive type, wrapper, String 등
  - 임베디드 타입: 복합 값 타입
  - 컬렉션 값 타입

### 임베디드 타입

![image](https://user-images.githubusercontent.com/57944099/169679647-3bea007d-1697-4c47-a199-ee0e58fa5e39.png)

- `@Embeddable`: 값 타입을 정의하는 곳에 표시
- `@Embedded` : 값 타입을 사용하는 곳에 표시

- 장점: 재사용성, 높은 응집도, 의미 있는 메소드 만들기 가능

### 값 타입과 불변 객체

- 값 타입 공유 참조 -> 여러 엔티티에서 하나의 값 타입 변경 시 side effect 발생
- 임베디드 타입의 경우 객체기 때문에 이런 side effect를 피할 길이 없음
  - 기본 타입은 값을 복사하기 때문에 공유되지 않지만, 참조 타입은 참조가 공유됨

```java
Address a = new Address(“Old”);
Address b = a; //객체 타입은 참조를 전달
b.setCity(“New”)
```

_그래서 등장한 게..._

### 불변 객체

**값 타입을 불변 객체로 설계하라**

- 불변 객체: 생성 시점 이후로 절대 값을 변경할 수 없는 객체

### 값 타입의 비교

- 동일성(identity) 비교: 인스턴스의 reference 비교, `==`
- 동등성(equivalence) 비교: 인스턴스의 value 비교, `equals`

- 값 타입은 a.equals(b)를 사용해서 동등성 비교를 해야 함 -> 적절히 재정의할 것

### 값 타입 컬렉션

![image](https://user-images.githubusercontent.com/57944099/169680054-3dbbc179-d6cb-4942-93a7-54c5e59ab7f6.png)

- `@ElementCollection`, `@CollectionTable`
- 데이터베이스는 컬렉션을 같은 테이블에 저장할 수 없기 때문에, 컬렉션을 저장하기 위한 별도의 테이블이 필요

- 제약사항: 식별자 개념이 없고 추적이 어려움, 삭제했다가 새로 저장해야
- 대안: 값타입 컬렉션 <<< 일대다 관계, 엔티티로 승격, 영속성 전이+고아 객체 제거
