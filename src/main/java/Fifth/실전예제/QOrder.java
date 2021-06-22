package Fifth.실전예제;

import Fourth.실전예제.OrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class QOrder {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "QMEMBER_ID")
    private QMember member;

    @OneToMany(mappedBy = "order")
    private List<QOrderItem> items;

    @OneToOne
    private QDelivery delivery;
    private Date orderDate;
    private OrderStatus orderStatus;
}
