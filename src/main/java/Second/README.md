๐ JPA ์ค์ 
-
```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.2"
             xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
    <persistence-unit name="hello">
        <properties>
            <!-- ํ์ ์์ฑ -->
            <property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
            <property name="javax.persistence.jdbc.user" value="sa"/>
            <property name="javax.persistence.jdbc.password" value=""/>
            <property name="javax.persistence.jdbc.url" value="jdbc:h2:tcp://localhost/~/test"/>
            <!-- jpa ์ค, ํ์ด๋ฒ๋ค์ดํธ๋ฅผ ์ฌ์ฉํ๊ธฐ ๋๋ฌธ์ ์๋ ์ค์ ๋ค์ hibernate์ผ๋ก ์์ ํฉ๋๋ค. -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>

            <!-- ์ต์ -->
            <!-- sql์ ๋ณด์ฌ์ค๋ค. -->
            <property name="hibernate.show_sql" value="true"/>
            <!-- sql์ ์์๊ฒ formating ํด์ค๋๋ค -->
            <property name="hibernate.format_sql" value="true"/>
            <!-- ์ฟผ๋ฆฌ๊ฐ ๋์จ ์ด์ ๋ฅผ ์ฃผ์ ํํ๋ก ๋์ ์ค๋๋ค. -->
            <property name="hibernate.use_sql_comments" value="true"/>
            <!--<property name="hibernate.hbm2ddl.auto" value="create" />-->
        </properties>
    </persistence-unit>
</persistence>
```
* ์ฌ๊ธฐ์ dialect ์ค์  ๋ถ๋ถ์, ๋ฐ์ดํฐ ๋ฒ ์ด์ค์ ๋ฐฉ์ธ์ผ๋ก DB๋ง๋ค ๋ฌธ๋ฒ์ด ๋ค๋ฅด๊ธฐ ๋๋ฌธ์ ์ด๋ค ๋ฐฉ์ธ์ ์ฌ์ฉํ ์ง ์ค์ ์ ํด์ฃผ๋ ๋ถ๋ถ์ด๋ค.
* JPA ์์ฒด๋ ํน์  DB์ ์ข์๋์ง ์๊ธฐ ๋๋ฌธ์ ์ ์ค์ ์ ๊ผญ ํด์ฃผ์ด์ผ ํ๋ค.


<br/>

๐ JPA ๊ธฐ๋ณธ template
-
```java
// EntityManagerFactory๋ฅผ ๋ง๋  ์๊ฐ DB์ ์ฐ๊ฒฐ ๋ฑ๋ฑ ๊ธฐ๋ณธ ์ค์ ์ ๋ชจ๋ ๋๋ ๊ฒ ์๋๋ค.
// EntityManagerFactory๋ฅผ ๋ง๋  ์๊ฐ DB์ ์ฐ๊ฒฐ ๋ฑ๋ฑ ๊ธฐ๋ณธ ์ค์ ์ ๋ชจ๋ ๋๋ ๊ฒ ์๋๋ค.
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
// ์ฟผ๋ฆฌ๋ฅผ ๋ ๋ฆฌ๊ธฐ ์ํด์๋ entityManager ๋ฅผ ์์ฑํด์ผ ํฉ๋๋ค.
// ํ๋์ ํธ๋์ ์ ๋จ์๋น ํ๋์ EntityManager๋ฅผ ์์ฑํด์ผ ํฉ๋๋ค.
EntityManager entityManager = entityManagerFactory.createEntityManager();

EntityTransaction entityTransaction = entityManager.getTransaction();

// ํธ๋์ ์ ์์
entityTransaction.begin();

try {
    // ์ค๊ฐ์ ๋ฌธ์ ๊ฐ ์๊ธธ ๊ฒฝ์ฐ rollback๋ ํด์ผ ํฉ๋๋ค.
    First.Member member = new First.Member();
    member.setId(2L);
    member.setName("HelloB");
    entityManager.persist(member);

    // ํธ๋์ ์ ์ปค๋ฐ
    entityTransaction.commit();
} catch (Exception e) {
    entityTransaction.rollback();
} finally {
    // ์ฌ์ฉํ ๋งค๋์ ์ ํฉํ ๋ฆฌ๋ ๋ซ์์ผ ํฉ๋๋ค. entityManager ๋ ํธ๋์ ์์ ๋ฌผ๊ณ  ๋์ด์ง๊ธฐ ๋๋ฌธ์ ๊ผญ ๋ซ์์ฃผ์ด์ผ ํ๋ฉฐ, ๊ทธ๋ ์ง ์์ ๊ฒฝ์ฐ DB์ ๋ถํ๊ฐ ์ ์  ์ปค์ง๋๋ค.
    entityManager.close();
}

// WAS๊ฐ close ๋  ๋ entityMangerFactory๋ก close ๋์ด์ผ ํจ
entityManagerFactory.close();
```


<br/>

๐ Entity class ์์ฑํ๊ธฐ
-
```java
@Entity
@Table(name = "USER") // USER ๋ผ๋ ์ด๋ฆ์ ํ์ด๋ธ
public class First.Member {
    @Id
    private Long id;
    @Column(name = "username") // username ์ด๋ผ๋ ์ด๋ฆ์ ์ปฌ๋ผ
    private String name;
```


<br/>

๐ JPA ๊ธฐ๋ณธ CURD
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
* JPA ์ ๊ฒฝ์ฐ, commit ์ ํ๋ ์์ ์ Entity ๊ฐ์ฒด์ ๊ฐ์ด ๋ณํ๊ฐ ์์๋์ง ์์๋์ง ๊ฒ์ฌ๋ฅผ ํ๊ธฐ ๋๋ฌธ์ ๋ณ๋ ์ ์ฅ ์์ด, set ๋ง ํด๋ update ์ฟผ๋ฆฌ๊ฐ ๋๊ฐ๋ค.



<br/>

๐ ์์์ผ ํ  ์ฌํญ
-
* ์ํฐํฐ ๋งค๋์  ํฉํ ๋ฆฌ๋ ํ๋๋ง ์์ฑํด์ ์ ํ๋ฆฌ์ผ์ด์ ์ ์ฒด์์ ๊ณต์ 
* ์ํฐํฐ ๋งค๋์ ๋ ์ฐ๋ ๋๊ฐ์ ๊ณต์ ํ์ง ์์ (๋ฌด์กฐ๊ฑด ์ฌ์ฉํ๊ณ  ๋ฒ๋ ค์ผ ํ๋ค)
* JPA ์ ๋ชจ๋  ๋ฐ์ดํฐ ๋ณ๊ฒฝ์ ํธ๋์ ์ ์์์ ์คํ



<br/>

๐ JPQL ๋ง๋ณด๊ธฐ
-
* JPQL์ ์๋์ ๊ฐ์ด ์ฌ์ฉ
```java
List<First.Member> memberList = entityManager.createQuery("select m from First.Member as m", First.Member.class).getResultList();

for (First.Member member : memberList) {
    System.out.println("name : " + member.getName());
}
```
* ์ด๋ from Member์์ Member๋ ํ์ด๋ธ์ด ์๋๋ผ, Entity ๊ฐ์ฒด์ด๋ค.
* ์ฆ, Entity ๊ฐ์ฒด๋ฅผ ๋ณด๊ณ  ์ฟผ๋ฆฌ๋ฅผ ๋ง๋๋ ๊ฒ์ด๋ค. ๊ทธ๋ ๊ธฐ ๋๋ฌธ์ "select m from MEMBER as m" ๊ณผ ๊ฐ์ด ํ์ด๋ธ ์ด๋ฆ์ผ๋ก ์ง๋ฉด ๋์ํ์ง ์๋๋ค.
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
* ์์ ๊ฐ์ ๋์์ ํ๋ฉด ์ฟผ๋ฆฌ๊ฐ ์๋์ผ๋ก ๋๊ฐ๋ ๊ฒ์ด ๋ณด์ธ๋ค.


<br/>

๐ JPQL์ ํ์ด์ง
-
```java
List<First.Member> memberList = entityManager.createQuery("select m from First.Member as m", First.Member.class)
        .setFirstResult(5)
        .setMaxResults(8)
        .getResultList();
```
* ์์ ๊ฐ์ด ํธ๋ฆฌํ๊ฒ ์ฌ์ฉํ  ์ ์์
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




