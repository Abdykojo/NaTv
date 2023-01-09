package kg.megacom.NaTv.models.repository;

import kg.megacom.NaTv.models.entity.Discounts;
import kg.megacom.NaTv.response.DiscountMinDaysResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DiscountsRepository extends JpaRepository<Discounts,Long> {
    @Query(value = "select d.min_days as minDays, d.percent from tb_discount d where d.channels_id_id=?1",nativeQuery = true)
    List<DiscountMinDaysResponse>getDiscountsByChannel(Long channelId);

    @Query(value = "select * from tb_discount d GROUP BY d.id HAVING MAX(min_days)<=?1 and d.channels_id_id=?2",nativeQuery = true)
    Discounts findAllByChannelsId(int days,Long channelsId);
}
