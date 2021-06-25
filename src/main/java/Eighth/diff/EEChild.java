package Eighth.diff;

import javax.persistence.*;

@Entity
public class EEChild {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private EEParent parent;

    public Long getId() {
        return id;
    }

    public EEChild setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EEChild setName(String name) {
        this.name = name;
        return this;
    }

    public EEParent getParent() {
        return parent;
    }

    public EEChild setParent(EEParent parent) {
        this.parent = parent;
        return this;
    }
}
