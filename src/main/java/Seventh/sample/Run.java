package Seventh.sample;

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

            UMember newMember = entityManager.find(UMember.class, member.getId());

            System.out.println("멤버만 조회하는 경우");
            System.out.println(newMember.getUsername());

            System.out.println("팀도 함께 조회하는 경우");
            System.out.println(newMember.getTeam().getName());


            entityManager.flush();
            entityManager.clear();

            System.out.println("프록시 객체를 조회하는 경우");
            UMember newMember1 = entityManager.getReference(UMember.class, member.getId());
            System.out.println("프록시 객체의 이름은 ? " + newMember1.getClass());
//            System.out.println(newMember1.getUsername());

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
