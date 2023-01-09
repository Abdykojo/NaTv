package kg.megacom.NaTv.models.repository;

import kg.megacom.NaTv.models.entity.Days;
import kg.megacom.NaTv.models.entity.Discounts;
import kg.megacom.NaTv.models.entity.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DaysRepository extends JpaRepository<Days,Long> {

}
