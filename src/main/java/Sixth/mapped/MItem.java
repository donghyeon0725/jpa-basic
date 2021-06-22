package Sixth.mapped;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MItem extends BaseEntity {
    @Id
    private Long id;
}
