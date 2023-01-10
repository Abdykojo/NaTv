package kg.megacom.NaTv.models.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PricesRequest {
    BigDecimal price;
}
