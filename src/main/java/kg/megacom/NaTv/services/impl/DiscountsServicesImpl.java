package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dto.DiscountDto;
import kg.megacom.NaTv.models.mapper.DiscountsMapper;
import kg.megacom.NaTv.models.repository.DiscountsRepository;
import kg.megacom.NaTv.response.DiscountMinDaysResponse;
import kg.megacom.NaTv.services.DiscountsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiscountsServicesImpl implements DiscountsServices {
    @Autowired
    DiscountsRepository rep;
    DiscountsMapper mapper=DiscountsMapper.INSTANCE;
    @Override
    public DiscountDto save(DiscountDto dto) {
        return mapper.toDto(rep.save(mapper.toEntity(dto)));
    }

    @Override
    public DiscountDto findById(Long id) {
        return DiscountsMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("")));
    }

    @Override
    public List<DiscountDto> findAll() {
        return DiscountsMapper.INSTANCE.toDtos(rep.findAll());
    }

}
