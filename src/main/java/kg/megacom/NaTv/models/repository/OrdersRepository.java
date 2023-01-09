package kg.megacom.NaTv.models.repository;

import kg.megacom.NaTv.models.entity.Channels;
import kg.megacom.NaTv.models.entity.Orders;
import kg.megacom.NaTv.response.ChannelRespInt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface OrdersRepository extends JpaRepository<Orders,Long> {

    @Query(value = "select o.orders_id_id as ordersId from tb_order_details o where o.channels_id_id=?1",nativeQuery = true)
    Orders findByChannelsId(Long id);

    @Query(value = "select o.name, o., c.name, p.price from tb_channels c JOIN tb_prices p ON c.id=p.channels_id_id ", nativeQuery = true)
    List<ChannelRespInt> channelResponseAll();

}
