package kg.megacom.NaTv.models.mapper;

import kg.megacom.NaTv.models.dto.DiscountDto;
import kg.megacom.NaTv.models.entity.Discounts;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper

public interface DiscountsMapper extends BaseMapper<Discounts, DiscountDto>{
    DiscountsMapper INSTANCE= Mappers.getMapper(DiscountsMapper.class);

}
