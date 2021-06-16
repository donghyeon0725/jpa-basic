package helloJPA_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class One_jpaMain {

    /**
     * Persistence가 META-INF에서 설정 파일을 읽어서
     * Entitiy Manager Factory 라는 클래스를 만들어서
     * Entity Manager를 만들고 그것을 통해서 동작한다.
     *
     * src/main/resources/META-INF/persistence.xml
     * 경로의 설정 파일이 필요 합니다.
     *
     * */
    public static void main(String[] args) {
        // EntityManagerFactory를 만든 순간 DB와 연결 등등 기본 설정은 모두 끝난 것 입니다.
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        // 쿼리를 날리기 위해서는 entityManager 를 생성해야 합니다.
        // 하나의 트랜젝션 단위당 하나의 EntityManager를 생성해야 합니다.
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        // 트랜젝션 시작
        entityTransaction.begin();

        try {
            List<Member> memberList = entityManager.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            for (Member member : memberList) {
                System.out.println("name : " + member.getName());
            }

            // 트랜젝션 커밋
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            // 사용한 매니저와 팩토리는 닫아야 합니다. entityManager 는 트랜젝션을 물고 늘어지기 때문에 꼭 닫아주어야 하며, 그렇지 않은 경우 DB에 부하가 점점 커집니다.
            entityManager.close();
        }

        entityManagerFactory.close();

    }
}
