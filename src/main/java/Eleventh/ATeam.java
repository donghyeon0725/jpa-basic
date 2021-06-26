package Eleventh;

import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ATeam {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<AMember> members;

    public Long getId() {
        return id;
    }

    public ATeam setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ATeam setName(String name) {
        this.name = name;
        return this;
    }

    public List<AMember> getMembers() {
        return members;
    }

    public ATeam setMembers(List<AMember> members) {
        this.members = members;
        return this;
    }
}
