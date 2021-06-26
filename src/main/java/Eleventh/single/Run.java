package Eleventh.single;

import Eleventh.AMember;
import Eleventh.ATeam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

            AMember member = new AMember();
            member.setName("멤버");
            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();

            System.out.println("묵시적 쿼리가 나가는 부분");
            entityManager.createQuery("select m.team from AMember m").getResultList();

            System.out.println("명시적 조인이 나가는 부분");
            entityManager.createQuery("select m.team from AMember m join m.team t").getResultList();

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
