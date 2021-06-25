package Seventh.util;

import Seventh.sample.UMember;
import Seventh.sample.UTeam;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;

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

            PersistenceUnitUtil util = entityManagerFactory.getPersistenceUnitUtil();
            UMember reference = entityManager.getReference(UMember.class, member.getId());

            System.out.println("아직 초기화 되지 않았습니다");
            System.out.println(util.isLoaded(reference));

            reference.getUsername();

            System.out.println(util.isLoaded(reference));


            entityManager.flush();
            entityManager.clear();
            UMember newReference = entityManager.getReference(UMember.class, member.getId());

            System.out.println("강제로 초기화 하는 방법입니다.");
            Hibernate.initialize(newReference);

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
