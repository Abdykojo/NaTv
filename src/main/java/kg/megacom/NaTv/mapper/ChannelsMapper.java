package kg.megacom.NaTv.mapper;

import kg.megacom.NaTv.models.dto.ChannelsDto;
import kg.megacom.NaTv.models.entity.Channels;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper

public interface ChannelsMapper extends BaseMapper<Channels, ChannelsDto>{
    ChannelsMapper INSTANCE= Mappers.getMapper(ChannelsMapper.class);

}
