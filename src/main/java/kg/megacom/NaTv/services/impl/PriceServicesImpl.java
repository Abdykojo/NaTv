package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dto.PricesDto;
import kg.megacom.NaTv.models.mapper.PricesMapper;
import kg.megacom.NaTv.models.repository.PricesRepository;
import kg.megacom.NaTv.services.PriceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceServicesImpl implements PriceServices {
    @Autowired
    PricesRepository rep;
    PricesMapper mapper=PricesMapper.INSTANCE;
    @Override
    public PricesDto save(PricesDto dto) {
        return mapper.toDto(rep.save(mapper.toEntity(dto)));
    }

    @Override
    public PricesDto findById(Long id) {
        return PricesMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("")));
    }

    @Override
    public List<PricesDto> findAll() {
        return PricesMapper.INSTANCE.toDtos(rep.findAll());
    }
}
