package ten.type;

import javax.persistence.*;

@Entity
public class NUser {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    public Long getId() {
        return id;
    }

    public NUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public NUser setName(String name) {
        this.name = name;
        return this;
    }

    public Type getType() {
        return type;
    }

    public NUser setType(Type type) {
        this.type = type;
        return this;
    }
}
