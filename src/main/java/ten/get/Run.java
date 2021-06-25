package ten.get;

import ten.LMember;

import javax.persistence.*;
import java.time.LocalDateTime;
import Nine.Period;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try {
            LMember member1 = new LMember();
            member1.setName("멤버 1");
            member1.setAge(17);
            member1.setPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));

            LMember member2 = new LMember();
            member2.setName("멤버 2");
            member2.setAge(25);
            member2.setPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));

            LMember member3 = new LMember();
            member3.setName("멤버 3");
            member3.setAge(11);
            member3.setPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));

            LMember member4 = new LMember();
            member4.setName("멤버 4");
            member4.setAge(63);
            member4.setPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));

            LMember member5 = new LMember();
            member5.setName("멤버 5");
            member5.setAge(33);
            member5.setPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));

            entityManager.persist(member1);
            entityManager.persist(member2);
            entityManager.persist(member3);
            entityManager.persist(member4);
            entityManager.persist(member5);

            entityManager.flush();
            entityManager.clear();

            System.out.println("엔티티 프로젝션 받기");
            TypedQuery<LMember> query1 = entityManager.createQuery("SELECT m from LMember m where m.age > 18", LMember.class);

            List<LMember> members1 = query1.getResultList();

            for (LMember m : members1)
                System.out.println(m.getName() + ", " + m.getAge());


            System.out.println("임베디드 프로젝션 받기");
            TypedQuery<Period> query2 = entityManager.createQuery("SELECT m.period from LMember m where m.age > 18", Period.class);

            List<Period> newMembers2 = query2.getResultList();

            for (Period m : newMembers2)
                System.out.println(m.getStartDate() + ", " + m.getEndDate());

            System.out.println("스칼라 프로젝션 받기");
            TypedQuery<Integer> query3 = entityManager.createQuery("SELECT m.age from LMember m where m.age > 18", Integer.class);

            List<Integer> newMembers3 = query3.getResultList();

            for (Integer m : newMembers3)
                System.out.println(m);

            // 트랜젝션 커밋
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
