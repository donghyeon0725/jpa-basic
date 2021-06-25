package ten;

import Nine.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LMember {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    private Period period;

    public Long getId() {
        return id;
    }

    public LMember setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LMember setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public LMember setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Period getPeriod() {
        return period;
    }

    public LMember setPeriod(Period period) {
        this.period = period;
        return this;
    }
}
