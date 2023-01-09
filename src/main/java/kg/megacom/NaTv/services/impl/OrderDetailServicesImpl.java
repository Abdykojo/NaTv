package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dto.OrderDetailsDto;
import kg.megacom.NaTv.models.dto.OrdersDto;
import kg.megacom.NaTv.models.entity.Discounts;
import kg.megacom.NaTv.models.mapper.OrderDetailMapper;

import kg.megacom.NaTv.models.repository.DiscountsRepository;
import kg.megacom.NaTv.models.repository.OrderDetailRepository;

import kg.megacom.NaTv.request.ChannelsRequest;

import kg.megacom.NaTv.services.ChannelsServices;
import kg.megacom.NaTv.services.DaysServices;
import kg.megacom.NaTv.services.OrderDetailServices;
import kg.megacom.NaTv.services.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderDetailServicesImpl implements OrderDetailServices {
    private final OrderDetailRepository rep;
    private final ChannelsServices services;
    private final DaysServices daysServices;
    private final DiscountsRepository discountsRepository;
    OrderDetailMapper mapper = OrderDetailMapper.INSTANCE;

    public OrderDetailServicesImpl(OrderDetailRepository rep, ChannelsServices services, DaysServices daysServices, DiscountsRepository discountsRepository) {
        this.rep = rep;
        this.services = services;
        this.daysServices = daysServices;
        this.discountsRepository = discountsRepository;
    }

    @Override
    public OrderDetailsDto save(OrderDetailsDto dto) {
        return mapper.toDto(rep.save(mapper.toEntity(dto)));
    }

    @Override
    public OrderDetailsDto findById(Long id) {
        return OrderDetailMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("")));
    }

    @Override
    public List<OrderDetailsDto> findAll() {
        return OrderDetailMapper.INSTANCE.toDtos(rep.findAll());
    }




    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Map<String,List<BigDecimal>> textCount(String text, List<ChannelsRequest> request) {
        String txt = text.replaceAll("\\s", "");
        BigDecimal totalPrice=BigDecimal.ZERO;
        BigDecimal noDiscPrice = BigDecimal.ZERO;
        List<BigDecimal>list=new ArrayList<>();
        List<BigDecimal>discPrice=new ArrayList<>();
        for (int i = 0; i < request.size(); i++) {
            BigDecimal priceByCount = request.get(i).getPrice();
            int countDays = daysServices.countDays(request.get(i).getDay());
            Discounts findDiscount = discountsRepository.findAllByChannelsId(countDays, request.get(i).getId());
            if (findDiscount == null) {
                BigDecimal sale = priceByCount.multiply(BigDecimal.valueOf(txt.length()));

                discPrice.add(sale);
                totalPrice=totalPrice.add(sale);

                continue;
            }
                BigDecimal firstPersent = priceByCount.multiply(BigDecimal.valueOf(findDiscount.getPercent()).divide(BigDecimal.valueOf(100)));
            System.out.println(firstPersent);
                BigDecimal second = priceByCount.subtract(firstPersent);
            System.out.println(second);
                BigDecimal third = second.multiply(BigDecimal.valueOf(txt.length()));
            System.out.println(third);
                BigDecimal four=third.multiply(BigDecimal.valueOf(countDays));
            System.out.println(four);
            BigDecimal two= priceByCount.multiply(BigDecimal.valueOf(txt.length()));
            BigDecimal one=two.multiply(BigDecimal.valueOf(countDays));
            list.add(four);
            totalPrice=totalPrice.add(four);
            discPrice.add(one);



            }
        List<BigDecimal>allPrice=Arrays.asList(totalPrice);
        Map<String,List<BigDecimal>> bigList = new HashMap<>();
        bigList.put("totalPrice",allPrice);
        System.out.println(allPrice+"ALLPRICE");
        bigList.put("prices", list);
        System.out.println(list+"list");
        bigList.put("pricesWithoutDiscount", discPrice);
        System.out.println(discPrice+"priceWd");

      //  bigList.put("pricesWithoutDiscount",noDiscPrice);

        return bigList;
    }

}

