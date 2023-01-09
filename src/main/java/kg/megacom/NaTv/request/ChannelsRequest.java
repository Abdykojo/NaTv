package kg.megacom.NaTv.request;

import kg.megacom.NaTv.models.entity.Channels;
import kg.megacom.NaTv.models.entity.Days;
import kg.megacom.NaTv.models.entity.Prices;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;

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
