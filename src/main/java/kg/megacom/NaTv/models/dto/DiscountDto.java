package kg.megacom.NaTv.models.dto;

import kg.megacom.NaTv.models.entity.Channels;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Setter
@Getter
public class DiscountDto {
    Long id;
    double percent;
    int minDays;
    Date startDate;
    Date endDate;
    Channels channelsId;
}
