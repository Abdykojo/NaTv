package kg.megacom.NaTv.models.dto;

import kg.megacom.NaTv.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class OrdersDto {
    Long id;
    String text;
    String name;
    String phone;
    String email;
    BigDecimal totalPrice;
    Date endDate;
    Date addDate;
    Status status;
}
