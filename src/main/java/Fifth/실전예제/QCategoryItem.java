package Fifth.실전예제;

import javax.persistence.*;

@Entity
public class QCategoryItem {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "QITEM_ID")
    private QItem item;

    @ManyToOne
    @JoinColumn(name = "QCATEGORY_ID")
    private QCategory category;
}
