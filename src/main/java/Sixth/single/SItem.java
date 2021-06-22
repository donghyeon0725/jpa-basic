package Sixth.single;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class SItem {
    @Id
    private Long id;

    private String name;

    private Integer price;

    public Long getId() {
        return id;
    }

    public SItem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SItem setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public SItem setPrice(Integer price) {
        this.price = price;
        return this;
    }
}
