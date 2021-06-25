package Nine.side;

import Nine.Address;
import Nine.Period;
import Nine.XMember;

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
            Address address = new Address("city", "address", "zipcode");

            XMember member1 = new XMember();
            member1.setPeriod(new Period());
            member1.setName("멤버 1");
            member1.setAddress(address);

            XMember member2 = new XMember();
            member2.setPeriod(new Period());
            member2.setName("멤버 2");
            member2.setAddress(address);

            entityManager.persist(member1);
            entityManager.persist(member2);

            member1.getAddress().setCity("newCity");


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
