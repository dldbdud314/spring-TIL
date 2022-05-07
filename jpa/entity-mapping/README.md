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
