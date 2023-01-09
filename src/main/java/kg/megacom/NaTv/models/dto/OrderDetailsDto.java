package kg.megacom.NaTv.models.dto;

import kg.megacom.NaTv.models.entity.Channels;
import kg.megacom.NaTv.models.entity.Orders;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Setter
@Getter
public class OrderDetailsDto {
    Long id;
    BigDecimal price;
    ChannelsDto channelsId;
    OrdersDto ordersId;

}
