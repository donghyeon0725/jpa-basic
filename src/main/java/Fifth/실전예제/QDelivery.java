package Fifth.실전예제;

import Fourth.실전예제.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QDelivery {
    @Id
    private Long id;

    private String city;

    private String street;

    private String zipCode;

    private OrderStatus orderStatus;

}
