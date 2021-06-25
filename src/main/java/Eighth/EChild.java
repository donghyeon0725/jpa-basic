package Eighth;

import javax.persistence.*;

@Entity
public class EChild {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private EParent parent;

    public Long getId() {
        return id;
    }

    public EChild setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EChild setName(String name) {
        this.name = name;
        return this;
    }

    public EParent getParent() {
        return parent;
    }

    public EChild setParent(EParent parent) {
        this.parent = parent;
        return this;
    }
}
