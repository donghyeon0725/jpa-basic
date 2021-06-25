package Nine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Box {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Box() {}

    public Box(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Box setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Box setName(String name) {
        this.name = name;
        return this;
    }
}
