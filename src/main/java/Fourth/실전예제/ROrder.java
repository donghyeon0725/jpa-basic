package Fourth.실전예제;

import java.util.Date;

public class ROrder {
    private Long id;
    private Long memberId;
    private Date orderDate;
    private OrderStatus orderStatus;

    public Long getId() {
        return id;
    }

    public ROrder setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getMemberId() {
        return memberId;
    }

    public ROrder setMemberId(Long memberId) {
        this.memberId = memberId;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public ROrder setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public ROrder setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }
}
