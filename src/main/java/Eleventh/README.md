π κ²½λ‘ ννμ
-
* μ (.)μ μ°μ΄ κ°μ²΄ κ·Έλνλ₯Ό νμνλ κ²
![default](./img/e3882757b8e54ec68f3b8cdab9a31878.png)
* μ΄λ€ κ²½λ‘λ₯Ό νμνλ μ§μ λ°λΌμ λμ€λ SQL μ λͺ¨μμ΄ λ¬λΌμ§λ€.
![default](./img/db503d429f1d485e9235296b51a74b91.png)


> κ²½λ‘ ννμ νΉμ§
* μν νλ : κ²½λ‘ νμμ λ
* λ¨μΌ κ° μ°κ΄ νλ : λ¬΅μμ  μ‘°μΈμ΄ λ°μ(*)
* μ»¬λ μ κ° μ°κ΄ νλ : λ¬΅μμ  μ‘°μΈμ΄ λ°μνμ§ μκ³ , κ²½λ‘ νμμ λμλλ€.
    * From μ μμ λͺμμ  μ‘°μΈμ ν΅ν΄, λ³μΉ­μ λΆμ¬νλ©΄ κ²½λ‘ νμμ΄ κ°λ₯ν΄μ§λλ€.


> λ¨μΌ κ° μ°κ΄ κ²½λ‘

![default](./img/7369689d723946938d449778796f1409.png)
* λ¬΅μμ μΈ λ΄λΆ μ‘°μΈμ΄ λ°μ
* [μ°Έκ³ ](single/Run.java)
* μΏΌλ¦¬ νλ λ¬Έμ λ‘ λ¬΅μμ  μ‘°μΈμ΄ λ°μν  μ μλ μΏΌλ¦¬λ μ¬μ©νμ§ μλ κ²μ΄ μ’κ³ , λͺμμ μΌλ‘ ν΄μ£Όμ΄μΌ ν©λλ€.
    * select t from AMember m join m.team t (select m.team from AMember m join m.team t)

> μ»¬λ μ κ° μ°κ΄ κ²½λ‘
* [μ°Έκ³ ](./collection/Run.java)
* λ¬΅μμ  λ΄λΆ μ‘°μΈμ΄ λ°μ
* sizeλ₯Ό μ μΈνλ©΄ κ±°μ νμν  μ μλ κ²λ μλ€.
* μ΄ λ λͺμμ μΌλ‘ μ‘°μΈμ ν΄μ λ³μΉ­μ λΆμ¬νλ©΄ κ²½λ‘ νμμ΄ κ°λ₯

> μ€λ¬΄ μ‘°μΈ
* κ°κΈμ  λ¬΅μμ  μ‘°μΈ λμ  λͺμμ  μ‘°μΈ μ¬μ©
* μ‘°μΈμ SQL μ μ€μ ν¬μΈνΈ
* λ¬΅μμ  μ‘°μΈμ μ‘°μΈμ΄ μΌμ΄λλ μν©μ νλμ νμνκΈ° μ΄λ €μ



<br/>

π fetch μ‘°μΈ
-
* [μ°Έκ³ ](./fetch/Run.java)
* SQL μ ν μ’λ₯κ° μλλλ€.
* JPQLμμ μ±λ₯ μ΅μ νλ₯Ό νκΈ° μν΄ μ κ³΅νλ κΈ°λ₯μλλ€.
* μ°κ΄λ μν°ν°λ, μ»¬λ μμ SQL νλ²μ μ‘°ννλ κΈ°λ₯
* join fetch ννλ‘ μ¬μ©
* ν¨μΉ μ‘°μΈ ::= [LEFT [OUTER]| INNER] JOIN FETCH μ‘°μΈ κ²½λ‘


> μν°ν° νμΉ μ‘°μΈ
* νμμ μ‘°ννλ©΄μ μ°κ΄λ νλ ν¨κ» μ‘°ν
* SQLμ λ³΄λ©΄ νμ λΏλ§ μλλΌ, ν(T.*)λ ν¨κ» μ‘°ν
* JPQL
```sql
select m from Member m join fetch m.team
```
* SQL
```sql
SELECT 
	M.*
	, T.* 
FROM MEMBER M 
	INNER JOIN TEAM T 
	ON M.TEAM_ID = T.ID
```
![default](./img/4cf51ed4fe434e09bfb7961a44b636bb.png)
* λμ λ°©λ²μ κ·Έλ₯ joinκ³Ό λμΌνλ€.
* λ€λ§, select μ μ λͺ¨λ  κ΄λ ¨ λ°μ΄ν°λ₯Ό μ‘°ν (μν°ν°κ° μλ κ²½μ° joinμ ν΄μ λ°μ΄ν°λ₯Ό μ λΆ κ°μ Έμ΄)νλ€λ μ μ΄ νΉμ§μ μ΄λ€.
* μ§μ°λ‘λ©μΌλ‘ μ€μ μ ν΄λμ΄λ μ¦μλ‘λ©μΌλ‘ λ°μ΄ν°λ₯Ό κ°μ Έμ¨λ€. (μΌλ° μ‘°μΈμ κ²½μ° μν°ν°λ₯Ό λͺμνμ§ μμΌλ©΄ μν°ν° κ°μ²΄λ νλ‘μλ‘ κ°μ Έμ¨λ€.)


> μ»¬λ μ νμΉ μ‘°μΈ
* λ€λμΌλ‘ μμνλ νμΉ μ‘°μΈμ μ ν λ¬Έμ κ° λ  κ²μ΄ μμ§λ§, μΌλλ€ νμΉ μ‘°μΈμ λ°μ΄ν°μ μ€λ³΅μ΄ λ°μνλ€. (μ»¬λ μμ κ²½μ° μΌλλ€)
* JPQL
    * select t from Team t join fetch t.members where t.name = 'A'
* SQL
    * select t.*, m.* from Team t inner join member m on t.id = m.team_id where t.name = 'A'
* => μ΄λ ν λ°μ΄ν°κ° μ€λ³΅μ΄ λ©λλ€. (DBμμλ ν 1κ° + λ©€λ² 1κ°λ₯Ό κ²°ν©ν λ°μ΄ν°λ₯Ό λ°ννμ§λ§, μν°ν°λ ν 1κ°μ ν λΉ λ λͺ¨λ  λ©€λ²λ₯Ό, DBμμ λ°νν row μλ§νΌ κ°μ§κ³  μκΈ° λλ¬Έμ΄λ€. κ·Έλ¦Όμ°Έκ³ )
![default](./img/d4fa5498b38d49cf964e37115ec14a9b.png)
* μν°ν° κ²°κ³Όλ₯Ό λ³΄λ©΄, JPAλ DBμμ λ°νν 2μ€μ λ°μ΄ν°λ₯Ό κ·Έλλ‘ λ°νν΄μΌ νκΈ° λλ¬Έμ κ°μ νAλ₯Ό λ°λΌλ³΄λ μν°ν°κ° 2κ° μκΈ°λ κ²μ΄λ€.
* μν°ν°λ₯Ό μΆλ ₯ν΄λ³΄λ©΄ ν 1κ° + λ©€λ² 1κ°κ° λ¬ΆμΈ μνκ° μλλΌ, ν 1κ°μ λ©€λ² 2λͺμ΄ λ¬ΆμΈ 2κ°μ μ€λ³΅ λ°μ΄ν°κ° μΆλ ₯λ©λλ€. (DBκ° 2μ€μ λ°ννκΈ° λλ¬Έμ JPAκ° μμλ‘ κ°μ μ€μ¬λ²λ¦΄ μ μκΈ° λλ¬Έμ μ΄λ°μΌμ΄ λ°μ)
![default](./img/6154a3fbd92842b586dfbfff789c117b.png)
* λ°λΌμ μ΄λ μ€λ³΅ μ κ±°μ νμμ±μ΄ μμ 


> νμΉ μ‘°μΈκ³Ό distinct
* SQLμ distinctλ μ€λ³΅ λ rowλ₯Ό μ κ±°νλ λͺλ Ή
* JPQL μμ distinct λ 2κ°μ§ κΈ°λ₯μ μ κ³΅
    1. SQLμ distinct μΆκ°
    2. μ νλ¦¬μΌμ΄μμμ μν°ν° μ€λ³΅ μ κ±°
* 1λ²μ κ²½μ° λ°μ΄ν°κ° μμ ν μ€λ³΅ λμ΄μΌ μ κ±°κ° κ°λ₯νκΈ° λλ¬Έμ μμ κ°μ μΌμ΄μ€μμλ μ κ±°ν  λ°©λ²μ΄ μμ
* νλ 2λ²μ κ²½μ° μνλ¦¬μΌμ΄μ λ¨μμ λ°μ΄ν°κ° μ€λ³΅ λκΈ° λλ¬Έμ 1μ€λ‘ κ°μ μ€μ΄μ€λλ€. => μμμ± μ»¨νμ€νΈ λ΄λΆμ μ€λ³΅λ κ°μ μ€μ¬μ€λ€λ μλ―Έ

> νμΉ μ‘°μΈ μ λ¦¬
* λ°μ΄ν°λ₯Ό μ‘°μΈν΄μ μ°κ΄ λ°μ΄ν°λ₯Ό νλ²μ κ°μ Έμ€λ κ²μ μλ―Έ
* λ€λμΌμ λ°μ΄ν° μ€λ³΅ λ¬Έμ κ° λ°μνμ§ μμ§λ§, μΌλλ€λ λ°μ΄ν° μ€λ³΅ λ¬Έμ κ° λ°μ
![default](./img/40537b7a8ce947679914f543dd9e8e0d.png)
* N + 1 λ¬Έμ  λν μΌλλ€μμ λ°μνλ λ¬Έμ μ  μλλ€. (μΌλλ€λ κΈ°λ³Έμ΄ λ μ΄μ§ λ‘λ©μ΄κΈ° λλ¬Έμ mμ νλ‘μλ‘ κ°μ Έμ΄)
* μ¦μ λ‘λ©μΌ λλ joinμ μ¬μ©νμ§ μμ κ²½μ° N + 1 λ¬Έμ λ₯Ό λ°μ μν΅λλ€.
* μ΄μ κ°μ λ¬Έμ λ₯Ό νμΉ μ‘°μΈμ ν΅ν΄μ ν΄κ²°ν  μ μμ΅λλ€.
* νμΉ μ‘°μΈμ κ°μ²΄ κ·Έλνλ₯Ό SQLμ νλ²μ μ‘°ννλ κ°λ(μ¦μ λ‘λ©)
* μ¬λ¬ νμ΄λΈμ μ‘°μΈν΄μ μν°ν°κ° κ°μ§ λͺ¨μμ΄ μλλΌ μ ν λ€λ₯Έ λͺ¨μμ κ²°κ³Όλ₯Ό λ΄μΌνλ€λ©΄, νμΉ μ‘°μΈ λ³΄λ€λ μΌλ° μ‘°μΈμ ν λ€μ μνλ λ°μ΄ν°λ§ DTOλ‘ λ°ννλ κ²μ΄ ν¨κ³Όμ  

> νμΉ μ‘°μΈμ νΉμ§κ³Ό νκ³
* ν¨μΉ μ‘°μΈ λμμλ λ³μΉ­μ μ€ μ μλ€.
    * νμ΄λ²λ€μ΄νΈλ μ¬μ© κ°λ₯νλ κ°κΈμ  μ¬μ© X
* λ μ΄μμ μ»¬λ μμ νμΉ μ‘°μΈ ν  μ μμ 
* μ»¬λ μμ νμΉ μ‘°μΈνλ©΄, νμ΄μ§ APIλ₯Ό μ¬μ©ν  μ μλ€. (νΉν μΌλλ€μμ νμ΄μ§μ μ¬μ©νλ©΄, μ€λ³΅ λ°μ΄ν°λΌμ μλ―Έκ° μμ΄μ§λλ€.)
    * νμ΄λ²λ€μ΄νΈμ κ²½μ°, κ²½κ³  λ‘κ·Έλ₯Ό λ¨κΈ°κ³  λͺ¨λ  λ°μ΄ν°λ₯Ό κ°μ Έμ¨ λ€ λ©λͺ¨λ¦¬μμ νμ΄μ§ νλλ° μ΄λ λ§€μ°λ§€μ° μνν©λλ€.
* μ°κ΄λ μν°ν°λ€μ SQL νλ²μ μ‘°ννλ―λ‘ μ±λ₯ μ΅μ νλ₯Ό ν  μ μλ€.
* μν°ν°μ μ§μ  μ μ©νλ κΈλ‘λ² μ λ΅λ³΄λ€ μ°μ μ΄λ€.
    * fetch = FetchType.LAZY // κΈλ‘λ² μ λ΅
* μ€λ¬΄μμ  κΈλ‘λ² μ λ΅μ λͺ¨λ LAZY μ΄κ³  μΌλλ€μμλ fetch joinμΌλ‘ μ¦μ λ‘λ©
* νμΉ μ‘°μΈμ λ³λμ λ³μΉ­μ μ£Όμ§ μλ κ²μ΄ μ’λ€.
    * νΉν, ν¨μΉ μ‘°μΈμ λ³μΉ­μ ν΅ν΄μ where μ‘°κ±΄μ κ±°λ κ²μ λμ± λ μ’μ§ μλ€.
    * μ°κ΄ λ κ²λ€μ λ€ λκ³  μ€κ² λ€λ λ§μΈλ°, μ‘°μΈλ λμμΌλ‘ μ‘°κ±΄μ κ±Έλ©΄ JPAμ μλμ λ€λ₯΄κ² λμν΄μ λ¬Έμ κ° λ  μ μμ
    * μμ κ°μ μν©μ΄ κΌ­ νμνλ€λ©΄, λ³λμ 2κ°μ μΏΌλ¦¬λ‘ λ λ¦¬λ κ²μ΄ λ§λ€.

> νμΉ μ‘°μΈμ νμ΄μ§ λ¬Έμ  ν΄κ²°
1. νμΉ μ‘°μΈμ κ²½μ° μΌλλ€μΈ κ²½μ° νμ΄μ§ λ¬Έμ κ° λ°μνλ κ²μ΄λ―λ‘, λ€λμΌ μͺ½μμ select ν΄μ νμ΄μ§ νλ λ°©ν₯μΌλ‘ ν΄κ²°νλ€. 
2. λλ λ°°μΉ μ¬μ΄μ¦λ₯Ό μ΄μ©ν΄μ ν΄κ²°
![default](./img/3b596dfff49d4bd695e65a89b2d09956.png)
    * members λ₯Ό μ‘°νν  λ νμ΄λΈμ select μΏΌλ¦¬λ₯Ό λͺ¨μ inμΌλ‘ νλ²μ λκ°λ κ²μ΄λ€.
    ![default](./img/02fd056b511944aaa915f950354c3e78.png)
    * μ μ€μ μ μν°ν° κ°μΈ μ€μ μ΄κ³ , λ³΄ν΅μ κΈλ‘λ² μ€μ μΌλ‘ λ§μ΄ κ°μ Έκ°λ€. 
    ![default](./img/47f97223a27749d1ab4d81ac41cbaab8.png)



<br/>


![default](./img/7d836fbbbc574b4d82ee90f3516461b8.png)

![default](./img/6e0df8f7fc854db483a78590fd028fc5.png)


<br/>


π μ‘°κ±΄μΌλ‘ μν°ν° vs ν€ κ° μ¬μ©
-
![default](./img/185fbf9eff944b09866ad874eb00aa5a.png)

![default](./img/9ae838488ce3478dbc85c44730f0c303.png)

![default](./img/5e9195f9d1d2446086c3f8b1ac816c3b.png)
* where λΆλΆμ member μν°ν°λ₯Ό μ‘°κ±΄μΌλ‘ κ±΄ λΆλΆμ΄ idλ‘ λ³κ²½ λμ΄ μλ€.

![default](./img/b42fb0f15761451eaad32cf9b0242b59.png)
* μ‘°κ±΄μΌλ‘ idλ₯Ό λͺμνμΌλ©΄ idλ₯Ό μν°ν°λ₯Ό λͺμνμΌλ©΄ μν°ν°λ₯Ό λ£μ΄μΌ νλ€.

![default](./img/f7830fa0eda940628dcb5aa7cb8666b9.png) 
* μ΄κ²μ μΈλν€λ₯Ό μ¬μ©ν  λμλ μ ν λ¬Έμ κ° μλ€.



<br/>

π Named μΏΌλ¦¬
-
![default](./img/50bdc2cabe9f4c52ae12bfb24ce2124f.png)

* μΏΌλ¦¬μ μ΄λ¦μ λΆμ¬ν΄λκ³  μ¬μ©ν  μ μμ
* μ μ  μΏΌλ¦¬μ΄κΈ° λλ¬Έμ νμν  λ whereμ μΆκ°νλ λ±μ νλμ ν  μ μμ
* λμ  μ νλ¦¬μΌμ΄μ λ‘λ© μμ μ μΏΌλ¦¬μ μ€λ₯κ° μμ κ²½μ° κ°μ§ν΄μ€ 
* μ΄λΈνμ΄μμ μ¬μ©νλ λ°©λ² & xmlμ μ μν΄λκ³  λΆλ¬μ μ¬μ©νλ λ°©λ²μ΄ μμ
![default](./img/51afaf39b88a44119c1cf46f97cd487a.png)
    * xmlμ΄ ν­μ μ°μ μμκ° λλ€.
    * μ νλ¦¬μΌμ΄μ νκ²½μ λ°λΌ λ€λ₯Έ xml μ μ¬μ©νλ κ²μ΄ κ°λ₯ν΄μ§λ€.
    * Spring Data JPA λ₯Ό μ¬μ©νλ©΄ μλμ κ°μ΄ μ΄λ¦ μλ named μΏΌλ¦¬ μ¬μ©μ΄ κ°λ₯ (νΉμ§μ Named μΏΌλ¦¬μ λμΌ)
    ![default](./img/60276332a9814e45937dcb806846d31c.png)


<br/>


π λ²ν¬ μ°μ°
-
* κ°μ νλ²μ insert, delete, update νλ κ²
* μλμ κ°μ μν©μ μ€νν΄μΌ νλ€κ³  κ°μ 
    * μ¬κ³ κ° 10κ° λ―Έλ§μΈ λͺ¨λ  μν κ°κ²©μ 10% μΈμ
* JPA λ³κ²½ κ°μ§λ‘ νκΈ°μ λλ¬΄ λ°©λν μμ 
    * λ°λΌμ SQL μΏΌλ¦¬λ₯Ό μ§μ  DBμ λ λ¦΄ νμ μμ
    * JPQL μμλ μμ κ°μ λμμ μ§μ

> λ²ν¬ μ°μ° μμ 

![default](./img/5c61a0ef6a884131995c5d74c264199f.png)
* νμ΄λ² λ€μ΄νΈμ κ²½μ° select ν΄μ insert νλ κ²λ μ§μ

> λͺ¨λ  νμμ λμ΄λ₯Ό 20μ΄λ‘ λ³κ²½νλ€λ©΄?

![default](./img/5e9e3b24384b47ee8b3c8e84af7120b7.png)

> λ²ν¬ μ°μ° μ μ£Όμν  μ 
* λ²ν¬ μ°μ°μ μμμ± μ»¨νμ€νΈμ μλ¬΄λ° κ΄λ ¨ μμ΄ λμνλ μ°μ°μ
* μ¦, λ²ν¬ μ°μ°μ νμ λ μ μ ν νμ΄λ°μ flushλ μλμΌλ‘ λκ°λ, clearλ₯Ό ν΄μ£Όμ§ μμΌλ©΄ μμμ± μ»¨νμ€νΈμ μλ κ°μ κ·Έλλ‘ μ¬μ©ν  κ°λ₯μ±μ΄ μμ(λλ update, delete λ λ΄μ©μ΄ λ°μλμ§ μνλ‘ κ°μ κ°μ Έμ΅λλ€)
![default](./img/94901b42b927411ea5d382f72617075b.png)
* update λ₯Ό μν νλλ°λ age κ° 0 μλλ€. clearλ₯Ό μννμ§ μμκΈ° λλ¬Έμλλ€.
![default](./img/ca334087222a42e1a888bd586e8faca9.png)

![default](./img/643b10a4acc1437a8fa60313fb1e2202.png)
