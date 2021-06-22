package Sixth.mapped;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {
    private Date createAt;
    private Date modifiedAt;
    private String creator;
    private String modifier;
}
