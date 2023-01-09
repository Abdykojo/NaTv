package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dto.ChannelsDto;
import kg.megacom.NaTv.models.dto.OrderDetailsDto;
import kg.megacom.NaTv.models.dto.OrdersDto;
import kg.megacom.NaTv.models.mapper.OrdersMapper;
import kg.megacom.NaTv.models.repository.ChannelsRepository;
import kg.megacom.NaTv.models.repository.OrderDetailRepository;
import kg.megacom.NaTv.models.repository.OrdersRepository;
import kg.megacom.NaTv.request.OrderRequest;
import kg.megacom.NaTv.response.ChanResponse;
import kg.megacom.NaTv.response.OrderResponse;
import kg.megacom.NaTv.services.ChannelsServices;
import kg.megacom.NaTv.services.DaysServices;
import kg.megacom.NaTv.services.OrderDetailServices;
import kg.megacom.NaTv.services.OrdersServices;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class OrdersServicesImpl implements OrdersServices {
    private final OrdersRepository rep;
    private final DaysServices services;
    private final ChannelsServices channelsServices;
    private final ChannelsRepository channelsRepository;
    final
    OrderDetailRepository orderDetailRepository;
    private final OrderDetailServices orderDetailServices;
    OrdersMapper mapper = OrdersMapper.INSTANCE;

    public OrdersServicesImpl(OrdersRepository rep, DaysServices services, ChannelsServices channelsServices, OrderDetailRepository orderDetailRepository, OrderDetailServices orderDetailServices, ChannelsRepository channelsRepository) {
        this.rep = rep;
        this.services = services;
        this.channelsServices = channelsServices;
        this.orderDetailRepository = orderDetailRepository;
        this.orderDetailServices = orderDetailServices;
        this.channelsRepository=channelsRepository;
    }

    @Override
    public OrdersDto save(OrdersDto dto) {
        return mapper.toDto(rep.save(mapper.toEntity(dto)));
    }

    @Override
    public OrdersDto findById(Long id) {
        return OrdersMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("")));
    }

    @Override
    public List<OrdersDto> findAll() {
        return OrdersMapper.INSTANCE.toDtos(rep.findAll());
    }


    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public OrderResponse saveOrder(OrderRequest request) {
        OrdersDto dto = new OrdersDto();
        OrderDetailsDto orderDetailsDto=new OrderDetailsDto();
        List<ChanResponse>chanResponses=new ArrayList<>();
        dto.setEmail(request.getEmail());
        dto.setName(request.getName());
        dto.setPhone(request.getPhone());
        if(request.getText().isEmpty()){
            throw new RuntimeException("Введите текст");
        }
        dto.setText(request.getText());
        Map<String,List<BigDecimal>> prices=orderDetailServices.textCount(request.getText(), request.getChannelsRequests());
        List<BigDecimal> totalPrice=prices.get("prices");
        List<BigDecimal> endPrice=prices.get("totalPrice");
        List<BigDecimal> withoutDiscountPrice=prices.get("pricesWithoutDiscount");

        dto.setTotalPrice(endPrice.get(0));
        dto=save(dto);
        for(int i=0;i< request.getChannelsRequests().size();i++) {

            orderDetailsDto.setChannelsId(channelsServices.findById(request.getChannelsRequests().get(i).getId()));
            orderDetailsDto.setOrdersId(dto);
            orderDetailsDto.setPrice(totalPrice.get(i));
            orderDetailServices.save(orderDetailsDto);

        }


        for(int i=0;i< request.getChannelsRequests().size();i++) {
            ChanResponse chanResponse=new ChanResponse();
            chanResponse.setId(request.getChannelsRequests().get(i).getId());
            chanResponse.setTvName(channelsRepository.channelName(request.getChannelsRequests().get(i).getId()));
            chanResponse.setPriceWithoutDiscount(withoutDiscountPrice.get(i));
            chanResponse.setPriceWithDiscount(totalPrice.get(i));

            chanResponses.add(chanResponse);
        }

            System.out.println("saveOrdDet");
        services.saveDays(request.getChannelsRequests(),dto);
        System.out.println("ok");


        return  new OrderResponse(dto.getName(),dto.getText(),dto.getPhone(),dto.getEmail(),dto.getTotalPrice(),chanResponses);
    }


}
