νλ‘μ
-


π λ μ΄μ§ λ‘λ© 
-
* [μμ  μ°Έκ³ ](./sample/Run.java) 
![default](./img/0ab90914166647498369220a39a3325f.png)

* member μ team μ μΌλλ€ κ΄κ³μ΄λ€.
* μ΄λ memberμ λΆμ΄μλ @ManyToOne μ΄λΈνμ΄μμ fetch μ λ΅ κΈ°λ³Έ κ°μ EAGER(μ¦μλ‘λ©)μ΄λ€.
* μ΄ λΆλΆμ fetch = FetchType.LAZY μΌλ‘ λ°κΏμ€μΌλ‘μ¨ Lazy Loading μ λ΅μΌλ‘ λ°κΏ μ μλ€.
```sql
    select
        umember0_.id as id1_21_0_,
        umember0_.team_id as team_id3_21_0_,
        umember0_.username as username2_21_0_ 
    from
        UMember umember0_ 
    where
        umember0_.id=?
λ©€λ²λ§ μ‘°ννλ κ²½μ°
μ μ 
νλ ν¨κ» μ‘°ννλ κ²½μ°
Hibernate: 
    select
        uteam0_.id as id1_23_0_,
        uteam0_.name as name2_23_0_ 
    from
        UTeam uteam0_ 
    where
        uteam0_.id=?
ν
6μ 24, 2021 5:03:25 μ€ν org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:h2:tcp://localhost/~/test]

Process finished with exit code 0
```
* μ μ λ₯Ό λ¨Όμ  μ‘°ννκ³ , λ€ λ¦κ² team μ΄ νμν  λ λ°μ΄ν°λ₯Ό λ‘λ© ν΄μ¨λ€λ κ²μ μ μ μλ€.
* μ΄κ² κ°λ₯ν μ΄μ λ μ΅μ΄ 1ν member λ₯Ό μ‘°ννμ λ, λ΄λΆμ team λ°μ΄ν°λ₯Ό κ°μ§μΈ νλ‘μ κ°μ²΄λ‘ κ°μ Έμ€κΈ° λλ¬Έμ κ°λ₯νλ€.



<br/>

π νλ‘μλ₯Ό κ°μ Έμ€λ λ°©λ²
-
* entityManager.find() : DB λλ μμμ± μ»¨νμ€νΈμμ Entityλ₯Ό μ‘°ννλ λ©μλ
* entityManager.getReference() : λ°μ΄ν°λ² μ΄μ€μ μ‘°νλ₯Ό λ―Έλ£¨λ κ°μ§ μν°ν°μΈ νλ‘μ κ°μ²΄λ₯Ό μ‘°ν
    ```java
    entityManager.flush();
    entityManager.clear();
    
    System.out.println("νλ‘μ κ°μ²΄λ₯Ό μ‘°ννλ κ²½μ°");
    UMember newMember1 = entityManager.getReference(UMember.class, member.getId());
    ```
    * μ μ²λΌ, μΆλ ₯μ νμ§ μλ μ΄μ κ°μ μ‘°ν νμ§ μμ
    ```java
    Hibernate: 
        select
            uteam0_.id as id1_23_0_,
            uteam0_.name as name2_23_0_ 
        from
            UTeam uteam0_ 
        where
            uteam0_.id=?
    ν
    νλ‘μ κ°μ²΄λ₯Ό μ‘°ννλ κ²½μ°
    ```

> getReferenceλ‘ κ°μ Έμ¨ κ°μ²΄
* memberμ ν΄λμ€λ₯Ό μ‘°ννλ©΄, memberκ° μλ proxy κ°μ²΄ μμ μ μ μλ€.
    ```java
    System.out.println("νλ‘μ κ°μ²΄μ μ΄λ¦μ ? " + newMember1.getClass());
    ```
    * κ²°κ³Ό
    ```text
    νλ‘μ κ°μ²΄μ μ΄λ¦μ ? class Seventh.sample.UMember$HibernateProxy$4lGWJTYh
    ```
  
> proxy κ°μ²΄μ λμ μλ¦¬
* JPA κ° Entityλ₯Ό κ°μΌ νλ‘μ κ°μ²΄λ₯Ό λ°ννλ€. μ΄λ Entityλ₯Ό μ°Έμ‘°ν  μ μλ target νλλ₯Ό κ°μ§κ³  μκ³ , μμμ λ°μκΈ° λλ¬Έμ Entity κ°μ²΄μ λμΌν λ©μλλ₯Ό κ°μ§κ³  μλ€.
* κ·Έλμ Entity λ³μλ‘ νλ‘μλ₯Ό λ°μ μ μλ κ²μ΄λ€.
![default](./img/a6e7b2b41c5b47d9a681de05c3944866.png)

> νλ‘μ κ°μ²΄μ μ λ¦¬
* μ€μ  ν΄λμ€λ₯Ό μμ λ°μμ λ§λ€μ΄μ§. μ€μ  Entity κ°μ²΄κ° μλλ€.
    * μ΄ κ² λλ¬Έμ Member μ Typeμ΄ λ€λ₯΄λ€. νμ μ²΄ν¬μμλ == λμ μ instance of λ₯Ό μ¬μ©ν΄μΌ ν©λλ€.
* μ€μ  ν΄λμ€μ κ² λͺ¨μμ΄ κ°λ€. (μμ)
* μ¬μ©νλ μμ₯μμλ μ§μ§ κ°μ²΄μΈμ§ νλ‘μ κ°μ²΄μΈμ§ κ΅¬λΆνμ§ μκ³  μ¬μ©νλ©΄ λ¨ (μ΄λ‘ μ)
* Entityμ λν μ°Έμ‘°(target)λ₯Ό λ³΄κ΄ => νλ‘μ κ°μ²΄λ₯Ό νΈμΆνλ©΄ νλ‘μκ° μ§μ§ μν°ν°μ λ©μλλ₯Ό λμ  νΈμΆν΄ μ€
![default](./img/cf807ff068e34137b3225830962edd07.png)

* νλ‘μ κ°μ²΄ λμ
    ![default](./img/5a1f244d1993476f9faff29b2c81cdca.png)
    * νλ‘μ κ°μ²΄λ₯Ό ν΅ν΄μ getNameμ νΈμΆνλ μκ° DBμμ κ°μ κ°μ Έμ Entityλ‘ μ μ₯μ ν΄λ‘λλ€.
    * κ·Έλ¦¬κ³  νλ‘μ κ°μ²΄μ μ΄ μν°ν°μ λν μ°Έμ‘°λ₯Ό μ μ₯ν©λλ€.
    * μ΄ ν μν°ν°μ getName λ©μλλ₯Ό νΈμΆν©λλ€.
    * μ΄κ²μ JPA νμ€μ μλλλ€.

* νλ‘μ κ°μ²΄λ μ²μ μ¬μ©ν  λ νλ²λ§ μ΄κΈ°ν λλ€.
* νλ‘μ κ°μ²΄λ₯Ό μ΄κΈ°ν νλ€κ³  ν΄μ νλ‘μ κ°μ²΄κ° μ€μ  μν°ν°λ‘ λ³νλ κ²μ΄ μλλ€. => μ κ·Όλ§ κ°λ₯ν κ²μ΄λ€.
* μμμ± μ»¨νμ€νΈμ μ°Ύλ μν°ν°κ° μ΄λ―Έ μμΌλ©΄ em.getReference()λ₯Ό νΈμΆν΄λ μ€μ  μν°ν°λ₯Ό λ°ν ν©λλ€.
    * 1μ°¨ μΊμμ μκΈ° λλ¬Έμ
* μ€μμ μνμΈ μν°ν°λ JPAμ λμμ λ°μ μ μκΈ° λλ¬Έμ μ΄κΈ°ν(κ°μ νΈμΆ) νλ €κ³  νλ©΄ λ¬Έμ κ° λ°μν©λλ€. (νμ΄λ²λ€μ΄νΈμ κ²½μ° Exception μ λ°ν) => μ€λ¬΄μμ μ΄λ° λ¬Έμ κ° λ§μ΄ λ°μν©λλ€.
    * [μ°Έκ³ ](./proxy/Run.java)
    ```text
    κ°μ²΄λ₯Ό μ΄κΈ°ν νμ§ μμ μνμμ μ€μμ μνλ‘ λ§λ­λλ€.
    μ€μμ μνμμ μ΄κΈ°ν
    org.hibernate.LazyInitializationException: could not initialize proxy [Seventh.sample.UMember#2] - no Session
    	at org.hibernate.proxy.AbstractLazyInitializer.initialize(AbstractLazyInitializer.java:169)
    	at org.hibernate.proxy.AbstractLazyInitializer.getImplementation(AbstractLazyInitializer.java:309)
    	at org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor.intercept(ByteBuddyInterceptor.java:45)
    	at org.hibernate.proxy.ProxyConfiguration$InterceptorDispatcher.intercept(ProxyConfiguration.java:95)
    	at Seventh.sample.UMember$HibernateProxy$jALDek90.getUsername(Unknown Source)
    	at Seventh.proxy.Run.main(Run.java:39)
    6μ 24, 2021 5:40:33 μ€ν org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl stop
    INFO: HHH10001008: Cleaning up connection pool [jdbc:h2:tcp://localhost/~/test]
    ```
    
> νλ‘μ κ°μ²΄μ νμ λΉκ΅ 
```java
System.out.println("νλ‘μλ‘ κ°μ Έμ¨ κ°μ²΄μ μΌλ° κ°μ²΄λ₯Ό λΉκ΅ν©λλ€");
UMember reference = entityManager.getReference(UMember.class, member.getId());

UMember normal = entityManager.find(UMember.class, member.getId());

System.out.println(normal.getClass() + ", " + reference.getClass()); // class Seventh.sample.UMember$HibernateProxy$z8ZYg544, class Seventh.sample.UMember$HibernateProxy$z8ZYg544

System.out.println(normal == reference); // true λ°ν
```
* [μ°Έκ³ ](./compare/Run.java)
* normal κ°μ²΄μ μμ§ κ°μ κ°μ Έμ€μ§ μμ reference κ°μ²΄λ₯Ό λΉκ΅ νμ λ trueλ₯Ό λ°νν©λλ€.
* JPA μ κ²½μ°, κ°μ PKμ νλ‘μ κ°μ²΄κ° μ΄λ―Έ μμμ± μ»¨νμ€νΈμ μλ€λ©΄ μ΄κΈ°ν νλ μμ μ μν°ν°λ₯Ό κ°μ Έμ€κ³  νλ‘μ κ°μ²΄μ μ°Έμ‘°κ°μ λλ€.
    * κ·Έλ¦¬κ³  λ λ€μ, κ°μ μν°ν°μ λν΄ μ‘°νκ° μΌμ΄λλ©΄ νλ‘μ κ°μ²΄λ₯Ό λ°ννλ€.
    * λ§μ½ νλ‘μ κ°μ²΄ μμ± μ΄μ μ μ΄λ―Έ κ°μ ν€κ°μ μν°ν°κ° μλ€λ©΄ νλ‘μ κ°μ²΄ λμ μ μΌλ° κ°μ²΄λ₯Ό λ°ννλ€.
* μ΄λ JPA κ° μ΄μ°¨νΌ, κ°μ²΄λ₯Ό ν€κ°μΌλ‘ κ΄λ¦¬νκ³  μκΈ° λλ¬Έμ κ°λ₯ν μΌμ΄λ©° == λΉκ΅λ₯Ό ν  μ μλλ‘ κ°μ pkμ κ°μ²΄μ΄λ©΄ DB 

> μ νΈμ ν΅ν κ°μ  μ΄κΈ°ν
* EntityManagerFactory μμ μ νΈμ κ°μ Έλ€κ° μ¬μ©ν  μ μλλ°, νλ‘μ κ°μ²΄κ° λ‘λ μνμΈμ§ νμΈν  μ μμ
    * [μ°Έκ³ ](./util/Run.java)
    ```text
    μμ§ μ΄κΈ°ν λμ§ μμμ΅λλ€
    false
    Hibernate: 
        select
            umember0_.id as id1_21_0_,
            umember0_.team_id as team_id3_21_0_,
            umember0_.username as username2_21_0_ 
        from
            UMember umember0_ 
        where
            umember0_.id=?
    true
    6μ 25, 2021 4:28:35 μ€ν org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl stop
    INFO: HHH10001008: Cleaning up connection pool [jdbc:h2:tcp://localhost/~/test]
    
    Process finished with exit code 0
    ```
* Hibernate λ κ°μ λ‘ μ΄κΈ°ν νλ λ©μλλ₯Ό μ κ³΅ν©λλ€.
    ```java
    UMember newReference = entityManager.getReference(UMember.class, member.getId());
    
    System.out.println("κ°μ λ‘ μ΄κΈ°ν νλ λ°©λ²μλλ€.");
    Hibernate.initialize(newReference);
    ```
  
<br/>

π Loading Mode μ€μ 
-
* JPAλ EAGER λ₯Ό κ΅¬ννκΈ° μν΄μ λκ°μ§ λ°©λ²μΌλ‘ κ΅¬νν  μ μλ€. (μν°ν°κ° 2κ°λΌκ³  κ°μ νλ€.)
    1. join μ ν΅ν΄μ νλ²μ κ°μ Έμ€λ λ°©λ² 
    2. μΏΌλ¦¬λ₯Ό 2λ² λ λ €μ κ°κ° κ°μ Έμ€λ λ°©λ²

> EAGER λ‘λ©μ μ¬μ©ν  λ λ¬Έμ μ 
* EAGER λ‘λ©μ JPA λ₯Ό ν΅ν΄μ find λ‘ μν°ν°λ₯Ό μ‘°νν  κ²½μ° join μ ν΅ν΄μ κ°μ²΄λ₯Ό νλ²μ κ°μ Έμ¨λ€.
* κ·Έλ°λ° JPQLμ ν΅ν΄μ κ°μ Έμ¬ κ²½μ° λ¨Όμ  μΏΌλ¦¬λ₯Ό λ§λ€μ΄μ λ λ¦°λ€. μ΄ λ JPAλ EAGER λ‘λ©μ λ³΄μ₯νκΈ° μν΄μ, EAGER λ‘ μ€μ λ μ°κ΄ μν°λ¦¬λ₯Ό μ‘°ννκΈ° μν΄ λ€μ DBλ₯Ό λ€λμ¨λ€.
    * λ§μ½ JPQL μΌλ‘ λ λ¦° μΏΌλ¦¬κ° κ°μ Έμ¨ Entityμ μκ° N κ°λΌκ³  κ°μ μ νλ©΄, DBμλ N (λͺ¨λ λ€ λ€λ₯Έ κ°μ²΄λ₯Ό κ°μ Έμ¬ λ) λ²μ μΏΌλ¦¬λ₯Ό λ λ λ €μΌ νλ€.
    * μ΄ λ¬Έμ λ₯Ό ν΄κ²°νλ λ°©λ²μΌλ‘ λ€μκ³Ό κ°μ 3κ°μ§ λ°©λ²μ΄ μλ€. 
        * ν¨μΉ μ‘°μΈμ ν΅ν΄μ νλ²μ load ν΄μ€λ λ°©λ²
        * λ°°μΉ μ¬μ΄μ¦λ₯Ό ν΅ν΄μ DB μ‘°ν μΏΌλ¦¬λ₯Ό νλ²μ λͺ¨μ κ°μ Έμ€λ λ°©λ²
        * μν°ν° κ·Έλνλ μ΄λΈνμ΄μμΌλ‘ νΈλ λ°©λ²
        
> Loading Mode μ λ¦¬
* κ°κΈμ  μ§μ° λ‘λ©λ§ μ¬μ© (νΉν μ€λ¬΄μμ)
* μ¦μ λ‘λ©μ μ¬μ©νλ©΄ μμμΉ λͺ»ν SQL μ΄ λ°μ
* μ¦μ λ‘λ©μ JPQL μμ N + 1 λ¬Έμ λ₯Ό μΌμΌν¨λ€.
* @ManyToOne, @OneToOne μ κΈ°λ³Έμ΄ μ¦μ λ‘λ©μ΄λ―λ‘, Lazy λ‘λ©μΌλ‘ λ³λ μ€μ μ ν΄μ£Όμ΄μΌ νλ€.
* @OneToMany, @ManyToMany λ κΈ°λ³Έμ μ§μ° λ‘λ©
* μ΄λ‘ μ μΌλ‘λ, νλ²μ μ¬μ©ν  μΌμ΄ λ§μ μν°ν°μ΄λ©΄ μ¦μλ‘λ©μΌλ‘(λ€νΈμνΉ λΉμ©μ μ€μ΄κΈ° μν΄μ), μλλΌλ©΄ μ§μ° λ‘λ©μΌλ‘ μ¬μ©νλ κ²μ΄ λ§μΌλ, μ΄λμμ JPQL μ μ¬μ©ν μ§λ λͺ¨λ₯΄λ μΌμ΄λ€.
    * λ°λΌμ λ¬΄μ‘°κ±΄ Lazy Loading μ μ¬μ©νλ κ²μ΄ λ§λ€.



<br/>
    
    
