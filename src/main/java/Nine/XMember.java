package Nine;

import javax.persistence.*;

@Entity
public class XMember {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="startDate", column = @Column(name = "S_DATE")),
            @AttributeOverride(name="endDate", column = @Column(name = "E_DATE")),
    })
    private Period secondPeriod;

    @Embedded
    private Period period;

    public Long getId() {
        return id;
    }

    public XMember setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public XMember setName(String name) {
        this.name = name;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public XMember setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Period getPeriod() {
        return period;
    }

    public XMember setPeriod(Period period) {
        this.period = period;
        return this;
    }
}
