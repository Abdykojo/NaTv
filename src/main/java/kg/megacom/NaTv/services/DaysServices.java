package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.dto.DaysDto;
import kg.megacom.NaTv.models.dto.OrdersDto;
import kg.megacom.NaTv.request.ChannelsRequest;
import kg.megacom.NaTv.request.DaysRequest;
import kg.megacom.NaTv.request.OrderRequest;

import java.util.List;

public interface DaysServices extends BaseService<DaysDto> {
    int saveDays(List<ChannelsRequest> request, OrdersDto dto);
    int countDays(List<DaysRequest> request);
}
