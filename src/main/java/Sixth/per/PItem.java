package Sixth.per;

import Sixth.join.JItem;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PItem {
    @Id
    private Long id;

    private String name;

    private Integer price;

    public Long getId() {
        return id;
    }

    public PItem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PItem setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public PItem setPrice(Integer price) {
        this.price = price;
        return this;
    }
}
