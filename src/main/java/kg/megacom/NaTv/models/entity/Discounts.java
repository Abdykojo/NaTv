package kg.megacom.NaTv.models.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Entity
@Table(name="tb_discount")
public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double percent;
    @Column(name = "min_days")
    int minDays;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    Date endDate;
    @ManyToOne
    @JoinColumn(name = "channels_id_id")
    Channels channelsId;

}
