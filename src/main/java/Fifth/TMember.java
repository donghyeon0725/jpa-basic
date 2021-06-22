package Fifth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TMember {
    @Id
    private Long id;

    @ManyToOne
    private TTeam team;

    private String username;

    public Long getId() {
        return id;
    }

    public TMember setId(Long id) {
        this.id = id;
        return this;
    }

    public TTeam getTeam() {
        return team;
    }

    public TMember setTeam(TTeam team) {
        this.team = team;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public TMember setUsername(String username) {
        this.username = username;
        return this;
    }
}
