package ten.type;

import javax.persistence.*;

public class Run {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try {
            NUser user = new NUser();
            user.setType(Type.AMDIN);
            user.setName("유저");
            entityManager.persist(user);

            Object o = entityManager.createQuery("select u from NUser u where u.type = ten.type.Type.AMDIN").getResultList();

            entityManager.createQuery("select u from NUser u where u.type = :type")
            .setParameter("type", Type.AMDIN)
            .getResultList();

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
