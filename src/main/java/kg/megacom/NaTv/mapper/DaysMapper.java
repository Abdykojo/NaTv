package kg.megacom.NaTv.mapper;

import kg.megacom.NaTv.models.dto.DaysDto;
import kg.megacom.NaTv.models.entity.Days;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper

public interface DaysMapper extends BaseMapper<Days, DaysDto>{
    DaysMapper INSTANCE= Mappers.getMapper(DaysMapper.class);
}
