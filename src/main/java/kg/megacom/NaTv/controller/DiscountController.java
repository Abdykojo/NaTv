package kg.megacom.NaTv.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.NaTv.models.dto.DiscountDto;
import kg.megacom.NaTv.services.DiscountsServices;
import kg.megacom.NaTv.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/disc")
@Api(tags = Swagger2Config.Discount)

public class DiscountController {
    @Autowired
    private DiscountsServices services;

    @PostMapping("/save")
    @ApiOperation(value = "Сохранение скидкок")
    public ResponseEntity<?> save(@RequestBody DiscountDto discountDto){
        try{
            return ResponseEntity.ok(services.save(discountDto));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
