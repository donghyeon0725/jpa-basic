package ten.on;

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
            LLTeam team = new LLTeam();
            team.setName("팀");
            entityManager.persist(team);

            LLMember member = new LLMember();
            member.setName("멤버");
            member.setTeam(team);
            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();

            Object o1 = entityManager.createQuery("select m, t from LLMember m join m.team t on t.name = '팀'").getResultList();
            Object o2 = entityManager.createQuery("select m, t from LLMember m join m.team t on t.name = m.name").getResultList();


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
