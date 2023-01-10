package kg.megacom.NaTv.mapper;

import kg.megacom.NaTv.models.dto.OrderDetailsDto;
import kg.megacom.NaTv.models.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper

public interface OrderDetailMapper extends BaseMapper<OrderDetail, OrderDetailsDto> {
    OrderDetailMapper INSTANCE= Mappers.getMapper(OrderDetailMapper.class);

}
