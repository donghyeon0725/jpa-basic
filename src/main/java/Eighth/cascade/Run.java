package Eighth.cascade;

import Eighth.EChild;
import Eighth.EParent;
import Fifth.TMember;
import Fifth.TTeam;

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
            EParent parent = new EParent();
            parent.setName("부모");

            EChild child1 = new EChild();
            child1.setName("자식1");
            child1.setParent(parent);

            EChild child2 = new EChild();
            child2.setName("자식2");
            child2.setParent(parent);

            parent.getChildList().add(child1);
            parent.getChildList().add(child2);
            System.out.println("영속성 저장");
            entityManager.persist(parent);

            entityManager.flush();
            entityManager.clear();

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
