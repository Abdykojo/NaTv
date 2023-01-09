package kg.megacom.NaTv.models.entity;

import kg.megacom.NaTv.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Entity
@Table(name="tb_orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    String name;
    String phone;
    String email;
    @Column(name = "total_price")
    BigDecimal totalPrice;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    Date endDate;
    @Column(name = "add_date")
    @Temporal(TemporalType.DATE)
    Date addDate;
    @Column(name = "status")
    Status status;

    @PrePersist
    protected void create() {
        endDate = new Date();
        addDate = new Date();
    }




}
