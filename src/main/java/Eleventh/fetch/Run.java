package Eleventh.fetch;

import Eleventh.AMember;
import Eleventh.ATeam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try {
            ATeam team = new ATeam();
            team.setName("팀");
            entityManager.persist(team);

            AMember member1 = new AMember();
            member1.setName("멤버1");
            member1.setTeam(team);
            entityManager.persist(member1);

            AMember member2 = new AMember();
            member2.setName("멤버2");
            member2.setTeam(team);
            entityManager.persist(member2);

            entityManager.flush();
            entityManager.clear();

            System.out.println("일반 조인");
            List<AMember> m1 = entityManager.createQuery("select m from AMember m join m.team", AMember.class).getResultList();
            List<AMember> m2 = entityManager.createQuery("select m from AMember m join fetch m.team", AMember.class).getResultList();

            for (AMember q : m1)
                System.out.println(q.getName() + ", " + q.getTeam().getName());

            for (AMember q : m2)
                System.out.println(q.getName() + ", " + q.getTeam().getName());


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
