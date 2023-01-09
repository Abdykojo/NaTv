package kg.megacom.NaTv.models.dto;

import kg.megacom.NaTv.models.entity.Channels;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class PricesDto {
    Long id;
    Date startDate;
    Date endDate;
    BigDecimal price;
    Channels channelsId;
}
