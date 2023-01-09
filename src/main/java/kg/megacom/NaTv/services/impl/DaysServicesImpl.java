package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dto.DaysDto;
import kg.megacom.NaTv.models.dto.OrdersDto;
import kg.megacom.NaTv.models.mapper.DaysMapper;
import kg.megacom.NaTv.models.repository.DaysRepository;
import kg.megacom.NaTv.models.repository.OrderDetailRepository;
import kg.megacom.NaTv.request.ChannelsRequest;
import kg.megacom.NaTv.request.DaysRequest;
import kg.megacom.NaTv.request.OrderRequest;
import kg.megacom.NaTv.services.DaysServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DaysServicesImpl implements DaysServices {
    @Autowired
    DaysRepository rep;
    @Autowired
            private OrderDetailRepository repository;
    DaysMapper mapper = DaysMapper.INSTANCE;

    @Override
    public DaysDto save(DaysDto dto) {
        return mapper.toDto(rep.save(mapper.toEntity(dto)));
    }

    @Override
    public DaysDto findById(Long id) {
        return DaysMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("")));
    }

    @Override
    public List<DaysDto> findAll() {
        return DaysMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Override
    public int saveDays(List<ChannelsRequest> request, OrdersDto dto) {
        if (request.size() == 0) {
            return 0;
        }
        int countDays = 0;
        for (int i = 0; i < request.size(); i++) {
            int length = request.get(i).getDay().get(0).getDay().length();
            String first = request.get(i).getDay().get(0).getDay();
            int count = 1;

            for (int f = 0; f < length - 1; f++) {

                if ((first.charAt(f) == ' ') && (first.charAt(f + 1) != ' ')) {

                    count++;
                }
            }

            countDays = count * request.get(i).getDay().size();
            DaysDto daysDto = new DaysDto();
            Long channelsId=dto.getId();
            Long ordersId=request.get(i).getId();
            daysDto.setOrderDetailId(repository.findByChannelsId(channelsId,ordersId));
            daysDto.setDay(countDays);
            save(daysDto);


        }
        return countDays;
    }
    @Override
    public int countDays(List<DaysRequest> request) {
        if (request.size() == 0) {
            return 0;
        }
        int countDays = 0;
        for (int i = 0; i < request.size(); i++) {
            int length = request.get(0).getDay().length();
            String first = request.get(0).getDay();
            int count = 1;

            for (int f = 0; f < length - 1; f++) {

                if ((first.charAt(f) == ' ') && (first.charAt(f + 1) != ' ')) {

                    count++;
                }
            }

            countDays = count * request.size();
        }
        return countDays;
    }
}
