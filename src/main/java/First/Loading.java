package First;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Loading {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try {
            /**

             DROP TABLE IF EXISTS USER;

             DROP TABLE IF EXISTS CLUB;

             DROP TABLE IF EXISTS TEAM;

             DROP TABLE IF EXISTS MEMBER;
             실행 뒤 수행하기

             */
            User user = new User(1L, "김강민1");
            Club club = new Club(2L, "club");
            Team team = new Team(3L, "team");
            user.setClub(club);
            user.setTeam(team);

            entityManager.persist(club);
            entityManager.persist(team);
            entityManager.persist(user);

            entityManager.flush();
            entityManager.clear();

            System.out.println("=====================");
            // Team은 이 시점에 가져옵니다.
            User selectedUser = entityManager.find(User.class, 1L);

            System.out.println("=====================");
            Club userClub = selectedUser.getClub();
            System.out.println("이름 출력");
            // 이 시점에 Club 쿼리가 날아갑니다.
            System.out.println(userClub.getName());

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
