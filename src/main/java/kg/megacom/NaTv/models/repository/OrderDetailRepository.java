package kg.megacom.NaTv.models.repository;

import kg.megacom.NaTv.models.entity.Channels;
import kg.megacom.NaTv.models.entity.Discounts;
import kg.megacom.NaTv.models.entity.OrderDetail;
import kg.megacom.NaTv.models.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    @Query(value = "select * from tb_order_details  where orders_id_id =?1 and channels_id_id=?2",nativeQuery = true)
    OrderDetail findByChannelsId(Long ordersId,Long channelsId);



}
