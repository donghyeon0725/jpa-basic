package Fifth.실전예제;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QMember {

    @Id
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipCode;
}
