package kg.megacom.NaTv.models.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Entity
@Table(name="tb_order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id")
    Long id;
    BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "channels_id_id")
    Channels channelsId;
    @ManyToOne
    @JoinColumn(name = "orders_id_id")
    Orders ordersId;



}
