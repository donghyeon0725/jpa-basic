package Seventh.proxy;

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

            UMember newMember = entityManager.getReference(UMember.class, member.getId());

            System.out.println("객체를 초기화 하지 않은 상태에서 준영속 상태로 만듭니다.");
            entityManager.detach(newMember);

            System.out.println("준영속 상태에서 초기화");
            System.out.println(newMember.getUsername());

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
