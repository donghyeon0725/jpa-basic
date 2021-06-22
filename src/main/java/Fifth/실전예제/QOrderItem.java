package Fifth.실전예제;

import javax.persistence.*;
import java.util.List;

@Entity
public class QOrderItem {
    @Id
    private Long id;

    @OneToMany
    @JoinColumn(name = "QORDER_ID")
    private QOrder order;

    @ManyToOne
    @JoinColumn(name = "QITEM_ID")
    private QItem item;

    private Integer orderPrice;

    private Integer count;
}
