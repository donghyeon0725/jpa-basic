package ten.on;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LLMember {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private LLTeam team;

    public Long getId() {
        return id;
    }

    public LLMember setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LLMember setName(String name) {
        this.name = name;
        return this;
    }

    public LLTeam getTeam() {
        return team;
    }

    public LLMember setTeam(LLTeam team) {
        this.team = team;
        return this;
    }
}
