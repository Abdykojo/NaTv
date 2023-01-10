package kg.megacom.NaTv.models.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelsRequest {
    Long id;
    List<DaysRequest>day;
    BigDecimal price;
    String name;
}
