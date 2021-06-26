package Eleventh;

import javax.persistence.*;

@Entity
public class AMember {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private ATeam team;

    public Long getId() {
        return id;
    }

    public AMember setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AMember setName(String name) {
        this.name = name;
        return this;
    }

    public ATeam getTeam() {
        return team;
    }

    public AMember setTeam(ATeam team) {
        this.team = team;
        return this;
    }
}
