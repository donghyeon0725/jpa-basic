package First;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DelayWrite {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try {

            User user1 = new User(1L, "김강민1");
            User user2 = new User(2L, "김강민2");
            User user3 = new User(3L, "김강민3");

            entityManager.persist(user1);
            entityManager.persist(user2);
            entityManager.persist(user3);

            System.out.println("이 때에는 쿼리가 날아가지 않고 commit 할 때 날아갑니다.");

            // 트랜젝션 커밋
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
