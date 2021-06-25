package Eighth.diff;

import javax.persistence.*;

@Entity
public class RRChild {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private RRParent parent;

    public Long getId() {
        return id;
    }

    public RRChild setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RRChild setName(String name) {
        this.name = name;
        return this;
    }

    public RRParent getParent() {
        return parent;
    }

    public RRChild setParent(RRParent parent) {
        this.parent = parent;
        return this;
    }
}
