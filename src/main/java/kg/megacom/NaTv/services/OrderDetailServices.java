package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.dto.OrderDetailsDto;
import kg.megacom.NaTv.models.request.ChannelsRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OrderDetailServices extends BaseService<OrderDetailsDto> {
    Map<String,List<BigDecimal>> textCount(String text, List<ChannelsRequest> request);

    }
