package Fifth.실전예제;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class QItem {
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
