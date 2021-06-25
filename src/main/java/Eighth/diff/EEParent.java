package Eighth.diff;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EEParent {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
    private List<EEChild> childList = new ArrayList();

    public Long getId() {
        return id;
    }

    public EEParent setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EEParent setName(String name) {
        this.name = name;
        return this;
    }

    public List<EEChild> getChildList() {
        return childList;
    }

    public EEParent setChildList(List<EEChild> childList) {
        this.childList = childList;
        return this;
    }
}
