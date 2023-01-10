package kg.megacom.NaTv.mapper;

import kg.megacom.NaTv.models.dto.OrdersDto;
import kg.megacom.NaTv.models.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper

public interface OrdersMapper extends BaseMapper<Orders, OrdersDto> {
    OrdersMapper INSTANCE= Mappers.getMapper(OrdersMapper.class);

}
