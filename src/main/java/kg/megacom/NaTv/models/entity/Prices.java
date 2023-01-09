package kg.megacom.NaTv.models.entity;

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
@Table(name="tb_prices")
public class Prices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    Date endDate;
    BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "channels_id_id")
    Channels channelsId;
}
