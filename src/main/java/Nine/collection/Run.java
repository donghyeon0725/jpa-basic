package Nine.collection;

import Nine.Address;
import Nine.Period;
import Nine.XMember;
import Nine.XUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class Run {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try {
            XUser user = new XUser();

            user.setName("유저");
            Period period = new Period(LocalDateTime.now(), LocalDateTime.now());
            user.getPeriods().add(period);
            user.getPeriods().add(new Period(LocalDateTime.now(), LocalDateTime.now()));

            entityManager.persist(user);

            entityManager.flush();
            entityManager.clear();

            XUser newUser = entityManager.find(XUser.class, user.getId());

            newUser.getPeriods().remove(period);
            newUser.getPeriods().add(new Period(LocalDateTime.now(), LocalDateTime.now()));



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
