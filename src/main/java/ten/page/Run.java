package ten.page;

import ten.LMember;

import javax.persistence.*;
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

            LMember member2 = new LMember();
            member2.setName("멤버 2");
            member2.setAge(25);

            LMember member3 = new LMember();
            member3.setName("멤버 3");
            member3.setAge(11);

            LMember member4 = new LMember();
            member4.setName("멤버 4");
            member4.setAge(63);

            LMember member5 = new LMember();
            member5.setName("멤버 5");
            member5.setAge(33);

            entityManager.persist(member1);
            entityManager.persist(member2);
            entityManager.persist(member3);
            entityManager.persist(member4);
            entityManager.persist(member5);

            entityManager.flush();
            entityManager.clear();

            System.out.println("페이징");
            List<LMember> members = entityManager.createQuery("SELECT m from LMember m", LMember.class)
                    .setFirstResult(2)
                    .setMaxResults(2)
                    .getResultList();

            for (LMember m : members)
                System.out.println(m.getName() + ", " + m.getAge());

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
