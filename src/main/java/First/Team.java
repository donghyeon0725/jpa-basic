package First;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {
    @Id
    private Long id;

    private String name;

    public Team() {}

    public Team(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
