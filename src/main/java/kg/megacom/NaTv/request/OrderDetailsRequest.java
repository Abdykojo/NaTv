package kg.megacom.NaTv.request;

import kg.megacom.NaTv.models.entity.Channels;
import kg.megacom.NaTv.models.entity.Days;
import kg.megacom.NaTv.models.entity.Orders;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailsRequest {
    Orders name;
    Orders text;
    Orders phone;
    Orders email;
    Orders totalPrice;
    List<Channels> channelsList;

}
