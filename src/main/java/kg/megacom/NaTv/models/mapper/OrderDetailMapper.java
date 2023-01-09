package kg.megacom.NaTv.models.mapper;

import com.fasterxml.jackson.databind.ser.Serializers;
import kg.megacom.NaTv.models.dto.OrderDetailsDto;
import kg.megacom.NaTv.models.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper

public interface OrderDetailMapper extends BaseMapper<OrderDetail, OrderDetailsDto> {
    OrderDetailMapper INSTANCE= Mappers.getMapper(OrderDetailMapper.class);

}
