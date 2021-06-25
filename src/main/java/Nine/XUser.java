package Nine;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class XUser {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(
            name = "PERIOD",
            joinColumns = @JoinColumn(name = "XUSER_ID")
    )
    private List<Period> periods = new ArrayList();


    public Long getId() {
        return id;
    }

    public XUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public XUser setName(String name) {
        this.name = name;
        return this;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public XUser setPeriods(List<Period> periods) {
        this.periods = periods;
        return this;
    }
}
