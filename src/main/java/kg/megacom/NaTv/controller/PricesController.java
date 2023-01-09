package kg.megacom.NaTv.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.NaTv.models.dto.PricesDto;
import kg.megacom.NaTv.services.PriceServices;
import kg.megacom.NaTv.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/price")
@Api(tags = Swagger2Config.Price)

public class PricesController {
    @Autowired
    private PriceServices services;

    @PostMapping("/save")
    @ApiOperation(value = "Сохранение цены")
    public ResponseEntity<?> save(@RequestBody PricesDto pricesDto){
        try{
            return ResponseEntity.ok(services.save(pricesDto));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
