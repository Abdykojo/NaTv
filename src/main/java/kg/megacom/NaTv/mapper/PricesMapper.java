package kg.megacom.NaTv.mapper;

import kg.megacom.NaTv.models.dto.PricesDto;
import kg.megacom.NaTv.models.entity.Prices;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PricesMapper extends BaseMapper<Prices, PricesDto>{
    PricesMapper INSTANCE= Mappers.getMapper(PricesMapper.class);

}
