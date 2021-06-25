package Eighth.diff;

import Eighth.EParent;

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
            EEParent parent = new EEParent();
            parent.setName("부모");
            entityManager.persist(parent);

            EEChild child1 = new EEChild();
            child1.setName("자식1");
            child1.setParent(parent);
            entityManager.persist(child1);

            EEChild child2 = new EEChild();
            child2.setName("자식2");
            child2.setParent(parent);
            entityManager.persist(child2);

            RRParent Rparent = new RRParent();
            Rparent.setName("부모");
            entityManager.persist(Rparent);

            RRChild Rchild1 = new RRChild();
            Rchild1.setName("자식1");
            Rchild1.setParent(Rparent);
            entityManager.persist(Rchild1);

            RRChild Rchild2 = new RRChild();
            Rchild2.setName("자식2");
            Rchild2.setParent(Rparent);
            entityManager.persist(Rchild2);

            entityManager.flush();
            entityManager.clear();

            EEParent parent1 = entityManager.find(EEParent.class, parent.getId());
            RRParent parent2 = entityManager.find(RRParent.class, Rparent.getId());

            System.out.println("orphanRemoval = true 인 경우 자식과 연관관계가 끊어지면 자동으로 삭제가 됩니다");
            parent2.getChildList().remove(0);

            System.out.println("부모가 삭제되면 자식도 삭제되는 것은 동일합니다.");
            entityManager.remove(parent2);

            System.out.println("cascade REMOVE 인 경우. child를 remove 해도 연관 객체가 끊어져도 delete 쿼리가 나가지 않습니다.");
            parent1.getChildList().remove(0);

            System.out.println("그러나 부모가 삭제되면 연관 객체를 삭제하는 동작은 orphanRemoval = true 상태와 동일합니다. 다만, 주의할 점은 자식을 제거한 채로 PARENT Entity를 remove 하려고 하면 하나 남아있는 자식 객체에는 remove 가 영속성 전이 되지 않기 때문에 무결성 제약 조건 에러가 발생합니다.");
            entityManager.remove(parent1);


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
