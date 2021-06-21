package First;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// 기본 생성자가 존재하여야 합니다.
@Entity
public class User {
    @Id
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY)
    private Club club;

    public User() {}

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Team getTeam() {
        return team;
    }

    public User setTeam(Team team) {
        this.team = team;
        return this;
    }

    public Club getClub() {
        return club;
    }

    public User setClub(Club club) {
        this.club = club;
        return this;
    }
}
