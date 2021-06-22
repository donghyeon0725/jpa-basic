package Fifth;

import javax.persistence.*;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try {
            TTeam team = new TTeam();
            team.setId(2L);
            team.setName("team");
            entityManager.persist(team);

            TMember member = new TMember();
            member.setId(1L);
            member.setTeam(team);
            member.setUsername("유저");
            entityManager.persist(member);
            // 아래 코드가 필요하다. => 이미 엔티티 관리 대상이고 team을 DB에서 가져오지 않기 때문에 team에 member가 빠져 있을 수 있다.
            // team.getMembers().add(member);

            entityManager.flush();
            entityManager.clear();

            TMember newMember = entityManager.find(TMember.class, 1L);
            // 팀도 영속성에 존재하게 된다.
            TTeam newTeam = member.getTeam();



            for (TMember m : entityManager.find(TTeam.class, 2L).getMembers()) {
                System.out.println(m.getUsername());
            }


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
