package ten.on;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LLTeam {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public LLTeam setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LLTeam setName(String name) {
        this.name = name;
        return this;
    }
}
