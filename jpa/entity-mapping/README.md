## 엔티티 매핑
👉 **객체와 관계형 DB를 어떻게 매핑해서 쓰는가 (설계적, 정적인 측면)**

- 객체와 테이블 매핑: `@Entity` `@Table`
- 필드와 컬럼 매핑: `@Column`
- 기본키 매핑: `@Id`
- 연관관계 매핑: `@ManyToOne` `@JoinColumn`

### 객체와 테이블, 필드와 컬럼 매핑 
````java
package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    @Transient //DB랑 관계없는 필드 - ex.메모리에서만 임시로 쓰고 싶은 경우
    private int tmp;

    public Member(){
    }
}
``````

![image](https://user-images.githubusercontent.com/57944099/167135941-8811a495-43c0-411d-a5b4-52b11b9244f8.png)

### 기본키 매핑 
- 직접 할당: `@Id`만 사용하기
- 자동 생성: `@GeneratedValue`도 함께 사용
  - DB에서 자동으로 생성해주는 PK와 매핑하는 방식

### 자동생성 방식 - 전략 소개
1. IDENTITY
2. SEQUENCE
3. TABLE

## 연관관계 매핑
- 객체는 참조 vs. 테이블은 외래키로 연관관계를 맺는다
- 즉, JPA 연관관계 매핑은 객체의 참고와 테이블의 외래키를 매핑하는 것

### 단방향 연관관계
```java
public class Member{
    //...
    
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
    
    //...
}
```
✅ 무슨 관계인지(다대일, 일대다 등) + 외래키 매핑 정보

### 양방향 연관관계
✨**여기서 등장하는 중요한 개념: 연관관계의 주인**✨
- 객체의 양방향 연관관계란? 👉 사실상 두개의 단방향 연관관계다.
    > 객체는 참조를 통해 다른 객체 접근.. 즉, 객체는 각자의 참조를 가지고 있다!<br>
    > 하나. A -> B, 둘. B -> A 

- 테이블의 양방향 연관관계란? 👉 FK를 통해 양방향 연관관계를 가진 셈이다
    > A 입장에서 B 알고 싶으면 `select * from A join A on A.id = B.id` <br>
    > 반대로 B 입장에서 A 알고 싶으면 `select * from B join B on B.id = A.id`

- 결국, 두개의 연관관계를 가진 객체 입장에서는, 둘 중 하나로 외래키를 관리해야 할 필요가 있다!
- 그게 바로 연관관계의 주인

### 연관관계 주인
- 연관관계의 주인만이 외래키를 관리하며,
- 주인이 아닌 쪽은 읽기만 가능함

- 누구를 주인으로? 👉 **외래키가 있는 곳으로!!**
