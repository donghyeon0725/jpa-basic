package Seventh.compare;

import Seventh.sample.UMember;
import Seventh.sample.UTeam;

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
            UTeam team = new UTeam();
            team.setName("팀");
            entityManager.persist(team);

            UMember member = new UMember();
            member.setUsername("유저");
            member.setTeam(team);
            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();

            System.out.println("프록시로 가져온 객체와 일반 객체를 비교합니다");
            UMember reference = entityManager.getReference(UMember.class, member.getId());

            UMember normal = entityManager.find(UMember.class, member.getId());

            System.out.println(normal.getClass() + ", " + reference.getClass());

            System.out.println(normal == reference);


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
