package kg.megacom.NaTv.response;

import kg.megacom.NaTv.models.entity.Discounts;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ChannelsResponse {
    Long id;
    String name;
    String photo;
    BigDecimal price;
    List<DiscountMinDaysResponse> discountMinDaysResponses;


}
