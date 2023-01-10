package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.dto.DaysDto;
import kg.megacom.NaTv.models.dto.OrdersDto;
import kg.megacom.NaTv.models.request.ChannelsRequest;
import kg.megacom.NaTv.models.request.DaysRequest;

import java.util.List;

public interface DaysServices extends BaseService<DaysDto> {
    int saveDays(List<ChannelsRequest> request, OrdersDto dto);
    int countDays(List<DaysRequest> request);
}
