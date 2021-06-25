package Nine.usage;

import Eighth.diff.EEChild;
import Eighth.diff.EEParent;
import Eighth.diff.RRChild;
import Eighth.diff.RRParent;
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
            XMember member = new XMember();
            member.setName("멤버");
            member.setPeriod(new Period());
            member.setAddress(new Address("city", "street", "zipCode"));
            entityManager.persist(member);

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
