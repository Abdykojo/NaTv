package kg.megacom.NaTv.request;

import kg.megacom.NaTv.models.entity.Channels;
import kg.megacom.NaTv.models.entity.Prices;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    String text;
    String name;
    String phone;
    String email;
    BigDecimal totalPrice;
    List<ChannelsRequest> channelsRequests;



}
