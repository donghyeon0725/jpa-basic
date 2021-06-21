package First;

import helloJPA_one.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class SamenessQuarantee {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try {

            User user = new User(1L, "김강민");
            entityManager.persist(user);

            // 쓰기 지연 모두 flush 한 다음, 초기화
            entityManager.flush();
            entityManager.clear();

            // 오직 한번 SQL 이 나간다.
            User user1 = entityManager.find(User.class, 1L);
            User user2 = entityManager.find(User.class, 1L);

            System.out.println("===========");
            // true
            System.out.println(user1 == user2);

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
