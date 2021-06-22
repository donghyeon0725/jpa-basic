package Sixth.join;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class JItem {
    @Id
    private Long id;

    private String name;

    private Integer price;

    public Long getId() {
        return id;
    }

    public JItem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public JItem setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public JItem setPrice(Integer price) {
        this.price = price;
        return this;
    }
}
