📌 JPA 설정
-
```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.2"
             xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
    <persistence-unit name="hello">
        <properties>
            <!-- 필수 속성 -->
            <property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
            <property name="javax.persistence.jdbc.user" value="sa"/>
            <property name="javax.persistence.jdbc.password" value=""/>
            <property name="javax.persistence.jdbc.url" value="jdbc:h2:tcp://localhost/~/test"/>
            <!-- jpa 중, 하이버네이트를 사용하기 때문에 아래 설정들은 hibernate으로 시작 합니다. -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>

            <!-- 옵션 -->
            <!-- sql을 보여준다. -->
            <property name="hibernate.show_sql" value="true"/>
            <!-- sql을 예쁘게 formating 해줍니다 -->
            <property name="hibernate.format_sql" value="true"/>
            <!-- 쿼리가 나온 이유를 주석 형태로 띄워 줍니다. -->
            <property name="hibernate.use_sql_comments" value="true"/>
            <!--<property name="hibernate.hbm2ddl.auto" value="create" />-->
        </properties>
    </persistence-unit>
</persistence>
```
* 여기서 dialect 설정 부분은, 데이터 베이스의 방언으로 DB마다 문법이 다르기 때문에 어떤 방언을 사용할지 설정을 해주는 부분이다.
* JPA 자체는 특정 DB에 종속되지 않기 때문에 위 설정을 꼭 해주어야 한다.


<br/>

📌 JPA 기본 template
-
```java
// EntityManagerFactory를 만든 순간 DB와 연결 등등 기본 설정은 모두 끝난 것 입니다.
// EntityManagerFactory를 만든 순간 DB와 연결 등등 기본 설정은 모두 끝난 것 입니다.
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
// 쿼리를 날리기 위해서는 entityManager 를 생성해야 합니다.
// 하나의 트랜젝션 단위당 하나의 EntityManager를 생성해야 합니다.
EntityManager entityManager = entityManagerFactory.createEntityManager();

EntityTransaction entityTransaction = entityManager.getTransaction();

// 트랜젝션 시작
entityTransaction.begin();

try {
    // 중간에 문제가 생길 경우 rollback도 해야 합니다.
    First.Member member = new First.Member();
    member.setId(2L);
    member.setName("HelloB");
    entityManager.persist(member);

    // 트랜젝션 커밋
    entityTransaction.commit();
} catch (Exception e) {
    entityTransaction.rollback();
} finally {
    // 사용한 매니저와 팩토리는 닫아야 합니다. entityManager 는 트랜젝션을 물고 늘어지기 때문에 꼭 닫아주어야 하며, 그렇지 않은 경우 DB에 부하가 점점 커집니다.
    entityManager.close();
}

// WAS가 close 될 때 entityMangerFactory로 close 되어야 함
entityManagerFactory.close();
```


<br/>

📌 Entity class 작성하기
-
```java
@Entity
@Table(name = "USER") // USER 라는 이름의 테이블
public class First.Member {
    @Id
    private Long id;
    @Column(name = "username") // username 이라는 이름의 컬럼
    private String name;
```


<br/>

📌 JPA 기본 CURD
-
> INSERT
```java
First.Member member = new First.Member();
member.setId(2L);
member.setName("HelloB");
entityManager.persist(member);
```

> SELECT
```java
First.Member member = entityManager.find(First.Member.class, 1L);
System.out.println("findManger id : " + member.getId());
System.out.println("findManger name : " + member.getName());
```

> DELETE
```java
First.Member member = entityManager.find(First.Member.class, 1L);
entityManager.remove(member);
```

> UPDATE
```java
First.Member member = entityManager.find(First.Member.class, 2L);
member.setName("Hello JPA");
```
* JPA 의 경우, commit 을 하는 시점에 Entity 객체에 값이 변화가 있었는지 없었는지 검사를 하기 때문에 별도 저장 없이, set 만 해도 update 쿼리가 나간다.



<br/>

📌 알아야 할 사항
-
* 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
* 엔티티 매니저는 쓰레드간에 공유하지 않음 (무조건 사용하고 버려야 한다)
* JPA 의 모든 데이터 변경은 트랜젝션 안에서 실행



<br/>

📌 JPQL 맛보기
-
* JPQL은 아래와 같이 사용
```java
List<First.Member> memberList = entityManager.createQuery("select m from First.Member as m", First.Member.class).getResultList();

for (First.Member member : memberList) {
    System.out.println("name : " + member.getName());
}
```
* 이때 from Member에서 Member는 테이블이 아니라, Entity 객체이다.
* 즉, Entity 객체를 보고 쿼리를 만드는 것이다. 그렇기 때문에 "select m from MEMBER as m" 과 같이 테이블 이름으로 짜면 동작하지 않는다.
```java
Hibernate: 
    /* select
        m 
    from
        First.Member as m */ select
            member0_.id as id1_0_,
            member0_.name as name2_0_ 
        from
            First.Member member0_
name : Hello JPA
```
* 위와 같은 동작을 하면 쿼리가 자동으로 나가는 것이 보인다.


<br/>

📌 JPQL의 페이징
-
```java
List<First.Member> memberList = entityManager.createQuery("select m from First.Member as m", First.Member.class)
        .setFirstResult(5)
        .setMaxResults(8)
        .getResultList();
```
* 위와 같이 편리하게 사용할 수 있음
```text
Hibernate: 
    /* select
        m 
    from
        First.Member as m */ select
            member0_.id as id1_0_,
            member0_.name as name2_0_ 
        from
            First.Member member0_ limit ? offset ?
```




