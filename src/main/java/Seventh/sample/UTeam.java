package Seventh.sample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UTeam {

    @Id @GeneratedValue
    private Long id;

    private String name;


    public Long getId() {
        return id;
    }

    public UTeam setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UTeam setName(String name) {
        this.name = name;
        return this;
    }
}
