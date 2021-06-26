package Eleventh.collection;

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

            entityManager.createQuery("select t.members from ATeam t").getResultList();
            List<ATeam> ts = entityManager.createQuery("select t from ATeam t join t.members m", ATeam.class).getResultList();

            System.out.println("N + 1 문제는 일대다일 때 발생하는 문제입니다");
            for (ATeam t : ts) {
                for (AMember m : t.getMembers()) {
                    System.out.println(m.getName() + ", " + m.getTeam().getName());
                }
            }

            List<ATeam> teams = entityManager.createQuery("select distinct t from ATeam t join fetch t.members m", ATeam.class).getResultList();

            for (ATeam t : teams) {
                for (AMember m : t.getMembers()) {
                    System.out.println(m.getName() + ", " + m.getTeam().getName());
                }
            }

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
