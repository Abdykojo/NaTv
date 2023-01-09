package kg.megacom.NaTv.response;

import kg.megacom.NaTv.models.dto.ChannelsDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    String text;
    String name;
    String phone;
    String email;
    BigDecimal totalPrice;


    List<ChanResponse>chanResponses;




    //    List<Long> id;
//    List<String> name;
//    List<BigDecimal> priceWithoutDiscount;
//    List<BigDecimal> priceWithDiscount;
//    List<String> tvName;
//    BigDecimal totalPrice;


}

