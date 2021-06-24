package Sixth.join;

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
            JBook book = new JBook();
            book.setId(1L);
            book.setName("책");
            book.setPrice(1000);
            book.setAuthor("저자");
            entityManager.persist(book);

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
