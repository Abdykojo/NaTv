package kg.megacom.NaTv.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ChanResponse {

    BigDecimal priceWithoutDiscount;
    BigDecimal priceWithDiscount;
    String tvName;
    Long id;
}
