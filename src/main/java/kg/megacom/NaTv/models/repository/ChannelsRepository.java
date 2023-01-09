package kg.megacom.NaTv.models.repository;

import kg.megacom.NaTv.models.dto.ChannelsDto;
import kg.megacom.NaTv.models.entity.Channels;
import kg.megacom.NaTv.response.ChannelRespInt;
import kg.megacom.NaTv.response.ChannelsResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelsRepository extends JpaRepository<Channels,Long> {
    @Query(value = "select c.id, c.photo, c.name, p.price from tb_channels c JOIN tb_prices p ON c.id=p.channels_id_id order by c.order_num", nativeQuery = true)
    List<ChannelRespInt> channelResponse(Pageable pageable);
    @Query(value = "select c.id, c.photo, c.name, p.price from tb_channels c JOIN tb_prices p ON c.id=p.channels_id_id ", nativeQuery = true)
    List<ChannelRespInt> channelResponseAll();
    @Query(value = "select  c.name  from tb_channels c where c.id=?1 ", nativeQuery = true)
    String channelName(Long id);

    @Query(value = "select c.id, c.photo, c.name, p.price from tb_channels c JOIN tb_prices p ON c.id=p.channels_id_id order by c.name", nativeQuery = true)
    List<ChannelRespInt> filtrationName (String filter);
    @Query(value = "select c.id, c.photo, c.name, p.price from tb_channels c JOIN tb_prices p ON c.id=p.channels_id_id order by p.price", nativeQuery = true)
    List<ChannelRespInt> filtrationPrice (String filter);
    @Query(value = "select c.id, c.photo, c.name, p.price from tb_channels c \n" +
            "JOIN tb_prices p ON c.id=p.channels_id_id JOIN tb_discount d ON c.id=d.channels_id_id ORDER by d.percent", nativeQuery = true)
    List<ChannelRespInt> filtrationPercent (String filter);
    @Query(value = "select c.id, c.photo, c.name, p.price from tb_channels c JOIN tb_prices p ON c.id=p.channels_id_id order by c.order_num", nativeQuery = true)
    List<ChannelRespInt> filtrationOrderNum (String filter);
}
