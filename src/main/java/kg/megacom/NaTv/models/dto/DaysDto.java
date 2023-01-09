package kg.megacom.NaTv.models.dto;

import kg.megacom.NaTv.models.entity.OrderDetail;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DaysDto {
    Long id;
    int day;
    OrderDetail orderDetailId;

}
