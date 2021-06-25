package Seventh.sample;

import javax.persistence.*;

@Entity
public class UMember {
    @Id @GeneratedValue
    private Long id;

    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    private UTeam team;

    public Long getId() {
        return id;
    }

    public UMember setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UMember setUsername(String username) {
        this.username = username;
        return this;
    }

    public UTeam getTeam() {
        return team;
    }

    public UMember setTeam(UTeam team) {
        this.team = team;
        return this;
    }
}
