package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.dto.ChannelsDto;
import kg.megacom.NaTv.models.entity.Channels;
import kg.megacom.NaTv.response.ChannelRespInt;
import kg.megacom.NaTv.response.ChannelsResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChannelsServices extends BaseService<ChannelsDto>{
     List<ChannelRespInt> channelResponse(Integer page, Integer size, boolean sortByOrderNum);
     List<ChannelsResponse>channelsResponseTest(Integer page, Integer size, boolean sortByOrderNum);

     String saveAll(String name, int orderNum, MultipartFile photo, Boolean isActive);

     List<ChannelsResponse> filtration(String filter);
}
