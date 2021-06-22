package Fifth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TTeam {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<TMember> members = new ArrayList();

    public Long getId() {
        return id;
    }

    public TTeam setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TTeam setName(String name) {
        this.name = name;
        return this;
    }

    public List<TMember> getMembers() {
        return members;
    }

    public TTeam setMembers(List<TMember> members) {
        this.members = members;
        return this;
    }
}
