package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.microservices.FileServiceFeign;
import kg.megacom.NaTv.models.dto.ChannelsDto;
import kg.megacom.NaTv.models.mapper.ChannelsMapper;
import kg.megacom.NaTv.models.repository.ChannelsRepository;
import kg.megacom.NaTv.models.repository.DiscountsRepository;
import kg.megacom.NaTv.response.ChannelRespInt;
import kg.megacom.NaTv.response.ChannelsResponse;
import kg.megacom.NaTv.services.ChannelsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelsServicesImpl implements ChannelsServices {
    @Autowired
    private DiscountsRepository discountsRepository;
    @Autowired
    ChannelsRepository rep;
    ChannelsMapper mapper = ChannelsMapper.INSTANCE;


    private final FileServiceFeign fileServiceFeign;

    public ChannelsServicesImpl(FileServiceFeign fileServiceFeign) {
        this.fileServiceFeign = fileServiceFeign;
    }


    @Override
    public ChannelsDto save(ChannelsDto dto) {
        return mapper.toDto(rep.save(mapper.toEntity(dto)));
    }

    @Override
    public ChannelsDto findById(Long id) {
        return ChannelsMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("")));
    }

    @Override
    public List<ChannelsDto> findAll() {
        return ChannelsMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Override
    public List<ChannelRespInt> channelResponse(Integer page, Integer size, boolean sortByOrderNum) {
        if (sortByOrderNum) return rep.channelResponse(PageRequest.of(page, size));
        else if (page != null && size != null) return rep.channelResponse((PageRequest.of(page, size)));
        else return rep.channelResponseAll();

    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public List<ChannelsResponse> channelsResponseTest(Integer page, Integer size, boolean sortByOrderNum) {
        List<ChannelRespInt> list = channelResponse(page, size, sortByOrderNum);
        List<ChannelsResponse> channelsResponseList = new ArrayList<>();
        for (ChannelRespInt item : list) {
            ChannelsResponse channelsResponse = new ChannelsResponse();
            channelsResponse.setId(item.getId());
            channelsResponse.setPrice(item.getPrice());
            channelsResponse.setPhoto(item.getPhoto());
            channelsResponse.setName(item.getName());

            channelsResponse.setDiscountMinDaysResponses(discountsRepository.getDiscountsByChannel(item.getId()));
            channelsResponseList.add(channelsResponse);
        }
        return channelsResponseList;
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public String saveAll(String name, int orderNum, MultipartFile multipartFile,Boolean isActive) {
        ChannelsDto dto=new ChannelsDto();
        dto.setName(name);
        dto.setOrderNum(orderNum);
        dto.setActive(isActive);
        dto.setPhoto(fileServiceFeign.sendPhoto(multipartFile).getDownloadUri());
        ChannelsDto channelsDto=save(dto);
        return channelsDto.getPhoto();
    }

    @Override
    public List<ChannelsResponse> filtration(String filter) {
        List<ChannelRespInt> list = null;
        List<ChannelsResponse> channelsResponseList = new ArrayList<>();
        if (filter.equals("name")) {
            list = rep.filtrationName(filter);
            for (ChannelRespInt item : list) {
                ChannelsResponse channelsResponse = new ChannelsResponse();
                channelsResponse.setId(item.getId());
                channelsResponse.setPrice(item.getPrice());
                channelsResponse.setPhoto(item.getPhoto());
                channelsResponse.setName(item.getName());

                channelsResponse.setDiscountMinDaysResponses(discountsRepository.getDiscountsByChannel(item.getId()));
                channelsResponseList.add(channelsResponse);
                rep.filtrationName(filter);
            }
        }
        if (filter.equals("price")) {
            list = rep.filtrationPrice(filter);
            for (ChannelRespInt item : list) {
                ChannelsResponse channelsResponse = new ChannelsResponse();
                channelsResponse.setId(item.getId());
                channelsResponse.setPrice(item.getPrice());
                channelsResponse.setPhoto(item.getPhoto());
                channelsResponse.setName(item.getName());

                channelsResponse.setDiscountMinDaysResponses(discountsRepository.getDiscountsByChannel(item.getId()));
                channelsResponseList.add(channelsResponse);
                rep.filtrationName(filter);
            }
        }
        if (filter.equals("percent")) {
            list = rep.filtrationPercent(filter);
            for (ChannelRespInt item : list) {
                ChannelsResponse channelsResponse = new ChannelsResponse();
                channelsResponse.setId(item.getId());
                channelsResponse.setPrice(item.getPrice());
                channelsResponse.setPhoto(item.getPhoto());
                channelsResponse.setName(item.getName());

                channelsResponse.setDiscountMinDaysResponses(discountsRepository.getDiscountsByChannel(item.getId()));
                channelsResponseList.add(channelsResponse);
                rep.filtrationName(filter);
            }
        }
            if (filter.equals("orderNum")) {
                list = rep.filtrationOrderNum(filter);
                for (ChannelRespInt item : list) {
                    ChannelsResponse channelsResponse = new ChannelsResponse();
                    channelsResponse.setId(item.getId());
                    channelsResponse.setPrice(item.getPrice());
                    channelsResponse.setPhoto(item.getPhoto());
                    channelsResponse.setName(item.getName());

                    channelsResponse.setDiscountMinDaysResponses(discountsRepository.getDiscountsByChannel(item.getId()));
                    channelsResponseList.add(channelsResponse);
                }

            }
            if(!filter.equals("orderNum")&!filter.equals("percent")&!filter.equals("price")&!filter.equals("name")){
                throw new RuntimeException("Вы ввели не правильное значение");
            }return channelsResponseList;

        }
    }
