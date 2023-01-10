package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.dto.OrdersDto;
import kg.megacom.NaTv.models.request.OrderRequest;
import kg.megacom.NaTv.response.OrderResponse;

public interface OrdersServices extends BaseService<OrdersDto>{

   OrderResponse saveOrder(OrderRequest request);



}
