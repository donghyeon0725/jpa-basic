package Eighth.diff;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RRParent {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<RRChild> childList = new ArrayList();

    public Long getId() {
        return id;
    }

    public RRParent setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RRParent setName(String name) {
        this.name = name;
        return this;
    }

    public List<RRChild> getChildList() {
        return childList;
    }

    public RRParent setChildList(List<RRChild> childList) {
        this.childList = childList;
        return this;
    }
}
