package Eighth;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EParent {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<EChild> childList = new ArrayList();

    public Long getId() {
        return id;
    }

    public EParent setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EParent setName(String name) {
        this.name = name;
        return this;
    }

    public List<EChild> getChildList() {
        return childList;
    }

    public EParent setChildList(List<EChild> childList) {
        this.childList = childList;
        return this;
    }
}
