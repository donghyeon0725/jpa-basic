package Fifth.실전예제;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class QItem extends BaseEntity {
    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "item")
    private List<QOrderItem> items;

    @OneToMany(mappedBy = "item")
    private List<QCategoryItem> categoryItems;

    private Integer price;

    private Integer stockQuantity;
}
